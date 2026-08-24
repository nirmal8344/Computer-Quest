package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileService {

    private final UserRepository userRepository;
    private final PlayerProgressRepository playerProgressRepository;

    public ProfileService(
            UserRepository userRepository,
            PlayerProgressRepository playerProgressRepository) {

        this.userRepository = userRepository;
        this.playerProgressRepository = playerProgressRepository;
    }

    public Map<String, Object> getProfile(Long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        PlayerProgress progress = playerProgressRepository
                .findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Player progress not found"));

        Map<String, Object> profile = new HashMap<>();

        profile.put("id", user.getId());
        profile.put("username", user.getUsername());
        profile.put("board", user.getBoard());
        profile.put("classLevel", user.getClassLevel());
        profile.put("school", user.getSchool());

        profile.put("chapter", progress.getCurrentChapter());
        profile.put("mission", progress.getCurrentMission());
        profile.put("lives", progress.getLives());
        profile.put("xp", progress.getXp());
        profile.put("answeredQuestions",
                progress.getAnsweredQuestions());

        return profile;
    }
}