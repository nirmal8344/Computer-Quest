package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.SchoolClass;
import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolClassRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final SchoolRepository schoolRepository;
    private final AdminRepository adminRepository;
    private final UnitRepository unitRepository;
    private final ChapterRepository chapterRepository;
    private final MissionRepository missionRepository;
    private final QuestionRepository questionRepository;

    public SchoolClassService(
            SchoolClassRepository schoolClassRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository,
            UnitRepository unitRepository,
            ChapterRepository chapterRepository,
            MissionRepository missionRepository,
            QuestionRepository questionRepository) {
        this.schoolClassRepository = schoolClassRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
        this.unitRepository = unitRepository;
        this.chapterRepository = chapterRepository;
        this.missionRepository = missionRepository;
        this.questionRepository = questionRepository;
    }

    public SchoolClass saveClass(SchoolClass schoolClass) {
        resolveSchool(schoolClass);
        if (schoolClass.getClassLevel() == null && schoolClass.getClassName() != null) {
            String digits = schoolClass.getClassName().replaceAll("\\D+", "");
            if (!digits.isEmpty()) {
                try {
                    schoolClass.setClassLevel(Integer.parseInt(digits));
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return schoolClassRepository.save(schoolClass);
    }

    private void resolveSchool(SchoolClass schoolClass) {
        if (schoolClass.getSchool() != null && schoolClass.getSchool().getId() != null) {
            schoolClass.setSchool(schoolRepository.findById(schoolClass.getSchool().getId()).orElse(null));
        } else if (schoolClass.getSchoolId() != null) {
            schoolClass.setSchool(schoolRepository.findById(schoolClass.getSchoolId()).orElse(null));
        } else if (schoolClass.getSchoolName() != null && !schoolClass.getSchoolName().trim().isEmpty()) {
            String name = schoolClass.getSchoolName().trim();
            schoolClass.setSchool(schoolRepository.findByName(name).orElseGet(() -> schoolRepository.save(new School(name))));
        } else if (schoolClass.getAdminId() != null) {
            Admin admin = adminRepository.findById(schoolClass.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                schoolClass.setSchool(admin.getSchool());
            }
        }
    }

    public List<SchoolClass> getClasses(String board, Long adminId, Long schoolId) {
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                schoolId = admin.getSchool().getId();
            }
        }

        List<SchoolClass> classes = new ArrayList<>();
        if (schoolId != null) {
            classes = board != null ? schoolClassRepository.findBySchool_IdAndBoard(schoolId, board)
                    : schoolClassRepository.findBySchool_Id(schoolId);
        } else {
            classes = board != null ? schoolClassRepository.findBySchoolIsNullAndBoard(board)
                    : schoolClassRepository.findBySchoolIsNull();
        }

        // If database has no classes seeded yet, seed defaults (11th Standard & 12th Standard)
        if (classes.isEmpty()) {
            SchoolClass c11 = saveClass(new SchoolClass("11th Standard", 11, board != null ? board : "CBSE"));
            SchoolClass c12 = saveClass(new SchoolClass("12th Standard", 12, board != null ? board : "CBSE"));
            classes.add(c11);
            classes.add(c12);
        }

        return classes;
    }

    public SchoolClass updateClass(Long id, SchoolClass updatedClass) {
        SchoolClass existing = schoolClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        existing.setClassName(updatedClass.getClassName());
        if (updatedClass.getClassLevel() != null) {
            existing.setClassLevel(updatedClass.getClassLevel());
        }
        if (updatedClass.getBoard() != null) {
            existing.setBoard(updatedClass.getBoard());
        }
        return schoolClassRepository.save(existing);
    }

    public void deleteClass(Long id) {
        SchoolClass existing = schoolClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Integer classLevel = existing.getClassLevel();
        String board = existing.getBoard();
        Long schoolId = existing.getSchool() != null ? existing.getSchool().getId() : null;

        // Cascade delete units, chapters, missions, questions for this class level
        if (classLevel != null) {
            List<Unit> units;
            if (schoolId != null) {
                units = unitRepository.findBySchool_IdAndBoardAndClassLevel(schoolId, board != null ? board : "CBSE", classLevel);
            } else {
                units = unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board != null ? board : "CBSE", classLevel);
            }
            for (Unit u : units) {
                unitRepository.delete(u);
            }
        }

        schoolClassRepository.deleteById(id);
    }
}
