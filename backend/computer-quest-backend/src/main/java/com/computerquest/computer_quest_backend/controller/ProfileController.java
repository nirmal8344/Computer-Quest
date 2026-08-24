package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    public Map<String, Object> getProfile(
            @PathVariable Long userId) {

        return profileService.getProfile(userId);
    }
}