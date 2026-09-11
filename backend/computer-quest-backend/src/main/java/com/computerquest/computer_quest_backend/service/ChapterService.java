package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final AdminRepository adminRepository;
    private final MissionRepository missionRepository;

    public ChapterService(
            ChapterRepository chapterRepository,
            UserRepository userRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository,
            MissionRepository missionRepository) {
        this.chapterRepository = chapterRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
        this.missionRepository = missionRepository;
    }

    public Chapter saveChapter(Chapter chapter) {
        resolveSchool(chapter);
        Chapter saved = chapterRepository.save(chapter);
        ensureDefaultMissions(saved);
        return saved;
    }

    private void ensureDefaultMissions(Chapter chapter) {
        List<Mission> existing = missionRepository.findByChapter_Id(chapter.getId());
        if (existing == null || existing.isEmpty()) {
            String[] defaultTypes = new String[]{"MCQ Quiz", "Fill in the Blank", "Scenario Challenge", "MCQ Quiz"};
            for (int m = 1; m <= 4; m++) {
                Mission mission = new Mission();
                mission.setMissionNumber(m);
                mission.setGameType(defaultTypes[m - 1]);
                mission.setChapter(chapter);
                if (chapter.getSchool() != null) {
                    mission.setSchool(chapter.getSchool());
                }
                missionRepository.save(mission);
            }
        }
    }

    private void resolveSchool(Chapter chapter) {
        if (chapter.getSchool() != null && chapter.getSchool().getId() != null) {
            chapter.setSchool(schoolRepository.findById(chapter.getSchool().getId()).orElse(null));
        } else if (chapter.getSchoolId() != null) {
            chapter.setSchool(schoolRepository.findById(chapter.getSchoolId()).orElse(null));
        } else if (chapter.getSchoolName() != null && !chapter.getSchoolName().trim().isEmpty()) {
            String name = chapter.getSchoolName().trim();
            chapter.setSchool(schoolRepository.findByName(name).orElseGet(() -> schoolRepository.save(new School(name))));
        } else if (chapter.getAdminId() != null) {
            Admin admin = adminRepository.findById(chapter.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                chapter.setSchool(admin.getSchool());
            }
        }
    }

    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    public List<Chapter> getChapters(String board, Integer classLevel, String subject, Long userId, Long adminId, Long schoolId) {
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                schoolId = admin.getSchool().getId();
                if (board == null) board = admin.getBoard();
            }
        }

        if (userId != null) {
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                if (board == null) board = user.getBoard();
                if (classLevel == null) classLevel = user.getClassLevel();
                if (schoolId == null && user.getSchool() != null) {
                    schoolId = user.getSchool().getId();
                }
            }
        }

        List<Chapter> rawResult = new ArrayList<>();
        if (schoolId != null) {
            if (board != null && classLevel != null && subject != null && !subject.trim().isEmpty()) {
                rawResult = chapterRepository.findBySchool_IdAndBoardAndClassLevelAndSubject(schoolId, board, classLevel, subject.trim());
            } else if (board != null && classLevel != null) {
                rawResult = chapterRepository.findBySchool_IdAndBoardAndClassLevel(schoolId, board, classLevel);
            } else {
                rawResult = chapterRepository.findBySchool_Id(schoolId);
            }

            if (rawResult.isEmpty()) {
                if (board != null && classLevel != null && subject != null && !subject.trim().isEmpty()) {
                    rawResult = chapterRepository.findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, subject.trim());
                    if (rawResult.isEmpty()) {
                        rawResult = chapterRepository.findByBoardAndClassLevelAndSubject(board, classLevel, subject.trim());
                    }
                } else if (board != null && classLevel != null) {
                    rawResult = chapterRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
                    if (rawResult.isEmpty()) {
                        rawResult = chapterRepository.findByBoardAndClassLevel(board, classLevel);
                    }
                } else {
                    rawResult = chapterRepository.findBySchoolIsNull();
                }
            }
        } else if (board != null && classLevel != null) {
            if (subject != null && !subject.trim().isEmpty()) {
                rawResult = chapterRepository.findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, subject.trim());
                if (rawResult.isEmpty()) {
                    rawResult = chapterRepository.findByBoardAndClassLevelAndSubject(board, classLevel, subject.trim());
                }
            }
            if (rawResult.isEmpty()) {
                rawResult = chapterRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
                if (rawResult.isEmpty()) {
                    rawResult = chapterRepository.findByBoardAndClassLevel(board, classLevel);
                }
            }
        }

        if (rawResult.isEmpty()) {
            rawResult = chapterRepository.findAll();
        }

        // Deduplicate and sort strictly in ascending order by chapterNumber (1, 2, 3, 4, 5, 6...)
        java.util.Map<Integer, Chapter> distinctMap = new java.util.LinkedHashMap<>();
        for (Chapter ch : rawResult) {
            int num = ch.getChapterNumber() != null ? ch.getChapterNumber() : 0;
            distinctMap.putIfAbsent(num, ch);
        }
        List<Chapter> result = new ArrayList<>(distinctMap.values());
        result.sort(java.util.Comparator.comparing(ch -> ch.getChapterNumber() != null ? ch.getChapterNumber() : 0));
        return result;
    }

    public List<Chapter> getChapters(String board, Integer classLevel, Long userId, Long adminId, Long schoolId) {
        return getChapters(board, classLevel, null, userId, adminId, schoolId);
    }

    public Chapter updateChapter(Long id, Chapter chapter) {
        Chapter existing = chapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chapter not found"));

        if (chapter.getAdminId() != null) {
            Admin admin = adminRepository.findById(chapter.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot modify chapter of another school.");
                }
            }
        }

        chapter.setId(existing.getId());
        resolveSchool(chapter);
        return chapterRepository.save(chapter);
    }

    public void deleteChapter(Long id) {
        deleteChapter(id, null);
    }

    public void deleteChapter(Long id, Long adminId) {
        Chapter existing = chapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chapter not found"));

        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot delete chapter of another school.");
                }
            }
        }

        // Delete child missions
        List<Mission> missions = missionRepository.findByChapter_Id(existing.getId());
        for (Mission m : missions) {
            missionRepository.delete(m);
        }

        chapterRepository.deleteById(id);
    }
}