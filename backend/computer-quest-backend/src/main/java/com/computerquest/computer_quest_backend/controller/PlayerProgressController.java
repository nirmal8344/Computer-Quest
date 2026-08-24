package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class PlayerProgressController {

    private final PlayerProgressRepository playerProgressRepository;
    private final UserRepository userRepository;

    public PlayerProgressController(
            PlayerProgressRepository playerProgressRepository,
            UserRepository userRepository) {

        this.playerProgressRepository = playerProgressRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public PlayerProgress saveProgress(@RequestBody PlayerProgress progress) {
        return playerProgressRepository.save(progress);
    }

    @GetMapping
    public List<PlayerProgress> getAllProgress() {
        return playerProgressRepository.findAll();
    }

    @PutMapping("/{progressId}/user/{userId}")
    public PlayerProgress connectUser(
            @PathVariable Long progressId,
            @PathVariable Long userId) {

        PlayerProgress progress = playerProgressRepository
                .findById(progressId)
                .orElseThrow(() ->
                        new RuntimeException("Progress not found"));

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        progress.setUser(user);

        return playerProgressRepository.save(progress);
    }

    @PutMapping("/{progressId}/xp/{xp}")
    public PlayerProgress updateXP(
            @PathVariable Long progressId,
            @PathVariable Integer xp) {

        PlayerProgress progress = playerProgressRepository
                .findById(progressId)
                .orElseThrow(() ->
                        new RuntimeException("Progress not found"));

        progress.setXp(xp);

        return playerProgressRepository.save(progress);
    }

    @PutMapping("/{progressId}/lives/{lives}")
    public PlayerProgress updateLives(
            @PathVariable Long progressId,
            @PathVariable Integer lives) {

        PlayerProgress progress = playerProgressRepository
                .findById(progressId)
                .orElseThrow(() ->
                        new RuntimeException("Progress not found"));

        progress.setLives(lives);

        return playerProgressRepository.save(progress);
    }
}