package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.service.AdminDashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/dashboard")
@CrossOrigin
public class AdminDashboardController {

    private final AdminDashboardService adminDashboardService;

    public AdminDashboardController(
            AdminDashboardService adminDashboardService) {
        this.adminDashboardService = adminDashboardService;
    }

    @GetMapping
    public Map<String, Long> getDashboard(
            @RequestParam(required = false) Long adminId) {
        return adminDashboardService.getDashboard(adminId);
    }
}