package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.dto.GameResponse;
import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {

    private final UserRepository userRepository;
    private final PlayerProgressRepository playerProgressRepository;

    public GameController(
            UserRepository userRepository,
            PlayerProgressRepository playerProgressRepository) {

        this.userRepository = userRepository;
        this.playerProgressRepository = playerProgressRepository;
    }

    @GetMapping("/{userId}")
    public GameResponse getGameData(
            @PathVariable Long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        PlayerProgress progress = playerProgressRepository
                .findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Player progress not found"));

        return new GameResponse(
                user.getId(),
                user.getUsername(),
                progress.getCurrentChapter(),
                progress.getCurrentMission(),
                progress.getLives(),
                progress.getXp(),
                user.getBoard(),
                user.getClassLevel(),
                user.getSchool()
        );
    }
}