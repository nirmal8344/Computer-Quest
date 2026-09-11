package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.dto.LeaderboardResponseDto;
import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.service.LeaderboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping
    public Object getLeaderboard(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) String board,
            @RequestParam(required = false) Integer classLevel,
            @RequestParam(required = false) Long schoolId) {

        return leaderboardService.getRankings(userId, subject, board, classLevel, schoolId);
    }

    @GetMapping("/rankings")
    public LeaderboardResponseDto getRankings(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) String board,
            @RequestParam(required = false) Integer classLevel,
            @RequestParam(required = false) Long schoolId) {

        return leaderboardService.getRankings(userId, subject, board, classLevel, schoolId);
    }
}