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

    public List<Unit> getUnits(String board, Integer classLevel, Long userId, Long adminId, Long schoolId) {
        // If query is by admin, scope to admin's school
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                return unitRepository.findBySchool_Id(admin.getSchool().getId());
            }
        }

        if (userId != null) {
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                board = user.getBoard();
                classLevel = user.getClassLevel();
                if (user.getSchool() != null) {
                    schoolId = user.getSchool().getId();
                }
            }
        }

        if (schoolId != null) {
            if (board != null && classLevel != null) {
                List<Unit> schoolUnits = unitRepository.findBySchool_IdAndBoardAndClassLevel(schoolId, board, classLevel);
                if (!schoolUnits.isEmpty()) {
                    return schoolUnits;
                }
            } else {
                List<Unit> schoolUnits = unitRepository.findBySchool_Id(schoolId);
                if (!schoolUnits.isEmpty()) {
                    return schoolUnits;
                }
            }
            // Fallback to global seeded content if no school specific content
            if (board != null && classLevel != null) {
                return unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
            }
            return unitRepository.findBySchoolIsNull();
        }

        if (board != null && classLevel != null) {
            List<Unit> units = unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
            if (!units.isEmpty()) {
                return units;
            }
        }

        return unitRepository.findAll();
    }

    public Unit updateUnit(Long id, Unit unit) {

        Unit existingUnit = unitRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Unit not found"));

        unit.setId(existingUnit.getId());

        return unitRepository.save(unit);
    }

    public void deleteUnit(Long id) {

        if (!unitRepository.existsById(id)) {
            throw new RuntimeException("Unit not found");
        }

        unitRepository.deleteById(id);
    }
}