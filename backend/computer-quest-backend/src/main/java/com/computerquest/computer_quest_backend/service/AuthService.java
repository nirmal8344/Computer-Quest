package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PlayerProgressRepository playerProgressRepository;
    private final SchoolRepository schoolRepository;

    public AuthService(
            UserRepository userRepository,
            PlayerProgressRepository playerProgressRepository,
            SchoolRepository schoolRepository) {
        this.userRepository = userRepository;
        this.playerProgressRepository = playerProgressRepository;
        this.schoolRepository = schoolRepository;
    }

    public User register(User user) {
        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
            user.setRole("STUDENT");
        }

        // Resolve School if provided by nested school object, schoolId, or schoolName
        if (user.getSchool() != null) {
            if (user.getSchool().getId() != null) {
                School school = schoolRepository.findById(user.getSchool().getId()).orElse(null);
                user.setSchool(school);
            } else if (user.getSchool().getName() != null && !user.getSchool().getName().trim().isEmpty()) {
                String name = user.getSchool().getName().trim();
                School school = schoolRepository.findByName(name)
                        .orElseGet(() -> schoolRepository.save(new School(name)));
                user.setSchool(school);
            }
        } else if (user.getSchoolId() != null) {
            School school = schoolRepository.findById(user.getSchoolId()).orElse(null);
            user.setSchool(school);
        } else if (user.getSchoolName() != null && !user.getSchoolName().trim().isEmpty()) {
            String name = user.getSchoolName().trim();
            School school = schoolRepository.findByName(name)
                    .orElseGet(() -> schoolRepository.save(new School(name)));
            user.setSchool(school);
        }

        User savedUser = userRepository.save(user);

        // Create default PlayerProgress if not already present
        PlayerProgress progress = new PlayerProgress();
        progress.setUser(savedUser);
        progress.setCurrentChapter(1);
        progress.setCurrentMission(1);
        progress.setLives(3);
        progress.setXp(0);
        progress.setAnsweredQuestions(0);

        playerProgressRepository.save(progress);

        // Populate transient fields so the JSON response includes school info
        if (savedUser.getSchool() != null) {
            savedUser.setSchoolId(savedUser.getSchool().getId());
            savedUser.setSchoolName(savedUser.getSchool().getName());
        }

        return savedUser;
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }

        // Populate transient fields so the JSON response includes school info
        if (user.getSchool() != null) {
            user.setSchoolId(user.getSchool().getId());
            user.setSchoolName(user.getSchool().getName());
        }

        return user;
    }
}