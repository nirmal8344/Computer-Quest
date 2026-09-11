package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.Subject;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.SubjectRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SchoolRepository schoolRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public SubjectService(
            SubjectRepository subjectRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository,
            UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    public List<Subject> getSubjects(String board, Integer classLevel, Long userId, Long adminId, Long schoolId) {
        return getSubjects(board, classLevel, userId, adminId, schoolId, null);
    }

    public List<Subject> getSubjects(String board, Integer classLevel, Long userId, Long adminId, Long schoolId, String studentGroup) {
        if (userId != null) {
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                if (board == null) board = user.getBoard();
                if (classLevel == null) classLevel = user.getClassLevel();
                if (studentGroup == null) studentGroup = user.getStudentGroup();
                if (schoolId == null && user.getSchool() != null) {
                    schoolId = user.getSchool().getId();
                }
            }
        }

        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                schoolId = admin.getSchool().getId();
            }
        }

        if (board != null && classLevel != null) {
            List<Subject> candidates;
            if (schoolId != null) {
                candidates = subjectRepository.findBySchool_IdAndBoardAndClassLevel(schoolId, board, classLevel);
                if (candidates.isEmpty()) {
                    candidates = subjectRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
                }
            } else {
                candidates = subjectRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
            }
            if (candidates.isEmpty()) {
                candidates = subjectRepository.findByBoardAndClassLevel(board, classLevel);
            }

            // Apply strict subject filter based on Board, ClassLevel, and Group
            List<String> requiredNames = getRequiredSubjectNames(board, classLevel, studentGroup);
            if (requiredNames != null && !requiredNames.isEmpty()) {
                List<Subject> filtered = new java.util.ArrayList<>();
                for (String reqName : requiredNames) {
                    for (Subject s : candidates) {
                        if (s.getSubjectName() != null && s.getSubjectName().trim().equalsIgnoreCase(reqName.trim())) {
                            if (!filtered.contains(s)) {
                                filtered.add(s);
                            }
                            break;
                        }
                    }
                }
                if (!filtered.isEmpty()) {
                    return filtered;
                }
            }
            return candidates;
        }

        return subjectRepository.findAll();
    }

    public static List<String> getRequiredSubjectNames(String board, Integer classLevel, String group) {
        if (board == null || classLevel == null) return java.util.Collections.emptyList();
        boolean isCbse = "CBSE".equalsIgnoreCase(board);

        if (classLevel <= 5) {
            if (isCbse) {
                // CBSE Class 4-5: English, Mathematics, EVS
                return java.util.List.of("English", "Mathematics", "EVS");
            } else {
                // State Board Class 4-5: Tamil, English, Mathematics, Science, Social Science
                return java.util.List.of("Tamil", "English", "Mathematics", "Science", "Social Science");
            }
        }

        if (classLevel <= 10) {
            if (isCbse) {
                // CBSE Class 6-10: English (Language), Mathematics, Science, Social Science
                return java.util.List.of("English", "Mathematics", "Science", "Social Science");
            } else {
                // State Board Class 6-10: Tamil, English, Mathematics, Science, Social Science
                return java.util.List.of("Tamil", "English", "Mathematics", "Science", "Social Science");
            }
        }

        // Classes 11 & 12
        String norm = group != null ? group.toUpperCase().trim() : "GROUP 1";
        if (!isCbse) {
            // Tamil Nadu State Board (Class 11 & 12)
            if (norm.contains("GROUP 7") || norm.contains("GROUP_7") || norm.contains("HISTORY") || norm.contains("ACCOUNTANCY + HISTORY")) {
                return java.util.List.of("Tamil", "English", "History", "Economics", "Commerce", "Accountancy");
            } else if (norm.contains("GROUP 5") || norm.contains("GROUP_5") || norm.contains("APPLICATION") || norm.contains("COMMERCE + COMPUTER") || norm.contains("COMMERCE_CA")) {
                return java.util.List.of("Tamil", "English", "Economics", "Commerce", "Accountancy", "Computer Applications");
            } else if (norm.contains("GROUP 6") || norm.contains("GROUP_6") || norm.contains("BUSINESS MATHEMATICS") || norm.contains("COMMERCE + BUSINESS") || norm.contains("COMMERCE_BM")) {
                return java.util.List.of("Tamil", "English", "Business Mathematics", "Economics", "Commerce", "Accountancy");
            } else if (norm.contains("GROUP 3") || norm.contains("GROUP_3") || norm.contains("PURE") || norm.contains("BOTANY")) {
                return java.util.List.of("Tamil", "English", "Physics", "Chemistry", "Botany", "Zoology");
            } else if (norm.contains("GROUP 2") || norm.contains("GROUP_2") || norm.contains("MATHS + COMPUTER") || norm.contains("MATHS + CS")) {
                return java.util.List.of("Tamil", "English", "Physics", "Chemistry", "Mathematics", "Computer Science");
            } else if (norm.contains("GROUP 1") || norm.contains("GROUP_1") || norm.contains("MATHS-BIOLOGY") || norm.contains("BIO-MATHS") || norm.contains("BIO")) {
                return java.util.List.of("Tamil", "English", "Physics", "Chemistry", "Mathematics", "Biology");
            } else {
                // Group 4 – COMMERCE
                return java.util.List.of("Tamil", "English", "Statistics", "Economics", "Commerce", "Accountancy");
            }
        } else {
            // CBSE (Class 11 & 12)
            if (norm.contains("GROUP 7") || norm.contains("GROUP_7") || norm.contains("HISTORY") || norm.contains("ACCOUNTANCY + HISTORY")) {
                return java.util.List.of("English", "Accountancy", "History", "Economics", "Business Studies");
            } else if (norm.contains("GROUP 5") || norm.contains("GROUP_5") || norm.contains("APPLICATION") || norm.contains("INFORMATICS") || norm.contains("COMMERCE + COMPUTER") || norm.contains("COMMERCE_CA")) {
                return java.util.List.of("English", "Accountancy", "Business Studies", "Economics", "Informatics Practices");
            } else if (norm.contains("GROUP 6") || norm.contains("GROUP_6") || norm.contains("BUSINESS MATHEMATICS") || norm.contains("COMMERCE + BUSINESS") || norm.contains("COMMERCE_BM")) {
                return java.util.List.of("English", "Accountancy", "Business Studies", "Economics", "Business Mathematics");
            } else if (norm.contains("GROUP 3") || norm.contains("GROUP_3") || norm.contains("PURE")) {
                return java.util.List.of("English", "Physics", "Chemistry", "Biology");
            } else if (norm.contains("GROUP 2") || norm.contains("GROUP_2") || norm.contains("MATHS + COMPUTER") || norm.contains("MATHS + CS")) {
                return java.util.List.of("English", "Physics", "Chemistry", "Mathematics", "Computer Science");
            } else if (norm.contains("GROUP 1") || norm.contains("GROUP_1") || norm.contains("MATHS-BIOLOGY") || norm.contains("BIO-MATHS") || norm.contains("BIO")) {
                return java.util.List.of("English", "Physics", "Chemistry", "Mathematics", "Biology");
            } else {
                // Group 4 – COMMERCE
                return java.util.List.of("English", "Accountancy", "Business Studies", "Economics", "Mathematics");
            }
        }
    }

    public Subject saveSubject(Subject subject) {
        resolveSchool(subject);
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Long id, Subject subject) {
        Subject existing = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
        if (subject.getAdminId() != null) {
            Admin admin = adminRepository.findById(subject.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot modify subject of another school.");
                }
            }
        }
        subject.setId(existing.getId());
        resolveSchool(subject);
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        deleteSubject(id, null);
    }

    public void deleteSubject(Long id, Long adminId) {
        Subject existing = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot delete subject of another school.");
                }
            }
        }
        subjectRepository.deleteById(id);
    }

    private void resolveSchool(Subject subject) {
        if (subject.getSchool() != null && subject.getSchool().getId() != null) {
            subject.setSchool(schoolRepository.findById(subject.getSchool().getId()).orElse(null));
        } else if (subject.getSchoolId() != null) {
            subject.setSchool(schoolRepository.findById(subject.getSchoolId()).orElse(null));
        } else if (subject.getSchoolName() != null && !subject.getSchoolName().trim().isEmpty()) {
            String name = subject.getSchoolName().trim();
            subject.setSchool(schoolRepository.findByName(name).orElseGet(() -> schoolRepository.save(new School(name))));
        } else if (subject.getAdminId() != null) {
            Admin admin = adminRepository.findById(subject.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                subject.setSchool(admin.getSchool());
            }
        }
    }
}
