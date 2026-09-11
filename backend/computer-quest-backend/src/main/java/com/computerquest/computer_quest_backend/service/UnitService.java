package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UnitRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final AdminRepository adminRepository;

    public UnitService(
            UnitRepository unitRepository,
            UserRepository userRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository) {
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
    }

    public Unit saveUnit(Unit unit) {
        resolveSchool(unit);
        return unitRepository.save(unit);
    }

    private void resolveSchool(Unit unit) {
        if (unit.getSchool() != null && unit.getSchool().getId() != null) {
            unit.setSchool(schoolRepository.findById(unit.getSchool().getId()).orElse(null));
        } else if (unit.getSchoolId() != null) {
            unit.setSchool(schoolRepository.findById(unit.getSchoolId()).orElse(null));
        } else if (unit.getSchoolName() != null && !unit.getSchoolName().trim().isEmpty()) {
            String name = unit.getSchoolName().trim();
            unit.setSchool(schoolRepository.findByName(name).orElseGet(() -> schoolRepository.save(new School(name))));
        } else if (unit.getAdminId() != null) {
            Admin admin = adminRepository.findById(unit.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                unit.setSchool(admin.getSchool());
            }
        }
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public List<Unit> getUnits(String board, Integer classLevel, String subject, Long userId, Long adminId, Long schoolId) {
        // If query is by admin, scope to admin's school
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                schoolId = admin.getSchool().getId();
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

        List<Unit> rawResult = new ArrayList<>();
        if (schoolId != null) {
            if (board != null && classLevel != null && subject != null && !subject.trim().isEmpty()) {
                rawResult = unitRepository.findBySchool_IdAndBoardAndClassLevelAndSubject(schoolId, board, classLevel, subject.trim());
            } else if (board != null && classLevel != null) {
                rawResult = unitRepository.findBySchool_IdAndBoardAndClassLevel(schoolId, board, classLevel);
            } else {
                rawResult = unitRepository.findBySchool_Id(schoolId);
            }

            if (rawResult.isEmpty()) {
                if (board != null && classLevel != null && subject != null && !subject.trim().isEmpty()) {
                    rawResult = unitRepository.findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, subject.trim());
                } else if (board != null && classLevel != null) {
                    rawResult = unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
                } else {
                    rawResult = unitRepository.findBySchoolIsNull();
                }
            }
        } else if (board != null && classLevel != null) {
            if (subject != null && !subject.trim().isEmpty()) {
                rawResult = unitRepository.findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, subject.trim());
                if (rawResult.isEmpty()) {
                    rawResult = unitRepository.findByBoardAndClassLevelAndSubject(board, classLevel, subject.trim());
                }
            }
            if (rawResult.isEmpty()) {
                rawResult = unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
            }
        }

        if (rawResult.isEmpty()) {
            rawResult = unitRepository.findAll();
        }

        // Deduplicate and sort strictly in ascending order by unitNumber (1, 2, 3, 4, 5...)
        java.util.Map<Integer, Unit> distinctMap = new java.util.LinkedHashMap<>();
        for (Unit u : rawResult) {
            int num = u.getUnitNumber() != null ? u.getUnitNumber() : 0;
            distinctMap.putIfAbsent(num, u);
        }
        List<Unit> result = new ArrayList<>(distinctMap.values());
        result.sort(java.util.Comparator.comparing(u -> u.getUnitNumber() != null ? u.getUnitNumber() : 0));
        return result;
    }

    public List<Unit> getUnits(String board, Integer classLevel, Long userId, Long adminId, Long schoolId) {
        return getUnits(board, classLevel, null, userId, adminId, schoolId);
    }

    public Unit updateUnit(Long id, Unit unit) {
        Unit existing = unitRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Unit not found"));

        if (unit.getAdminId() != null) {
            Admin admin = adminRepository.findById(unit.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot modify unit of another school.");
                }
            }
        }

        unit.setId(existing.getId());
        resolveSchool(unit);
        return unitRepository.save(unit);
    }

    public void deleteUnit(Long id) {
        deleteUnit(id, null);
    }

    public void deleteUnit(Long id, Long adminId) {
        Unit existing = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found"));

        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot delete unit of another school.");
                }
            }
        }

        unitRepository.deleteById(id);
    }
}