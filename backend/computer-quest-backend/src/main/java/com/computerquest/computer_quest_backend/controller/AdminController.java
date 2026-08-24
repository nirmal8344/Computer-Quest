package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
        try {
            Admin saved = adminService.saveAdmin(admin);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public List<Admin> getAllAdmins(
            @RequestParam(required = false) Long adminId) {
        return adminService.getAdminsBySchool(adminId);
    }

    @GetMapping("/users")
    public List<User> getSchoolUsers(
            @RequestParam Long adminId) {
        return adminService.getUsersByAdminSchool(adminId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        try {
            Admin result = adminService.login(
                    admin.getUsername(),
                    admin.getPassword()
            );
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}