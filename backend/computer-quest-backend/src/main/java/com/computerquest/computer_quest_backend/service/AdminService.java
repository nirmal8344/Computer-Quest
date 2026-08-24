package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;

    public AdminService(
            AdminRepository adminRepository,
            UserRepository userRepository,
            SchoolRepository schoolRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
    }

    public Admin saveAdmin(Admin admin) {
        // Check duplicate username safely using findAllByUsername
        List<Admin> existing = adminRepository.findAllByUsername(admin.getUsername());
        if (!existing.isEmpty()) {
            throw new RuntimeException("Username already exists. Please choose a different username.");
        }

        // Resolve school: prefer schoolId, then schoolName
        if (admin.getSchoolId() != null) {
            School school = schoolRepository.findById(admin.getSchoolId()).orElse(null);
            admin.setSchool(school);
        } else if (admin.getSchoolName() != null && !admin.getSchoolName().trim().isEmpty()) {
            // Find existing school or create new one
            School school = schoolRepository.findByName(admin.getSchoolName().trim()).orElse(null);
            if (school == null) {
                school = new School(admin.getSchoolName().trim());
                school = schoolRepository.save(school);
            }
            admin.setSchool(school);
        } else if (admin.getSchool() != null && admin.getSchool().getId() != null) {
            School school = schoolRepository.findById(admin.getSchool().getId()).orElse(null);
            admin.setSchool(school);
        }

        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    /**
     * Returns admins belonging to the same school as the given admin.
     * Falls back to all admins if adminId is null or admin has no school.
     */
    public List<Admin> getAdminsBySchool(Long adminId) {
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                return adminRepository.findBySchoolId(admin.getSchool().getId());
            }
        }
        return adminRepository.findAll();
    }

    /**
     * Returns students (users) belonging to the same school as the given admin.
     * Falls back to all users if adminId is null or admin has no school.
     */
    public List<User> getUsersByAdminSchool(Long adminId) {
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                return userRepository.findBySchoolId(admin.getSchool().getId());
            }
        }
        return userRepository.findAll();
    }

    public Admin login(String username, String password) {
        Admin admin = adminRepository
                .findFirstByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Admin not found"));

        if (!admin.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return admin;
    }
}