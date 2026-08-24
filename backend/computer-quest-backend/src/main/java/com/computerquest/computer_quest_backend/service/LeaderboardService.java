package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    private final PlayerProgressRepository playerProgressRepository;
    private final UserRepository userRepository;

    public LeaderboardService(
            PlayerProgressRepository playerProgressRepository,
            UserRepository userRepository) {
        this.playerProgressRepository = playerProgressRepository;
        this.userRepository = userRepository;
    }

    public List<PlayerProgress> getLeaderboard(Long userId, Long schoolId) {
        if (userId != null) {
            User u = userRepository.findById(userId).orElse(null);
            if (u != null && u.getSchool() != null) {
                return playerProgressRepository.findByUser_School_IdOrderByXpDesc(u.getSchool().getId());
            }
        }
        if (schoolId != null) {
            return playerProgressRepository.findByUser_School_IdOrderByXpDesc(schoolId);
        }
        return playerProgressRepository.findAllByOrderByXpDesc();
    }

    public List<PlayerProgress> getLeaderboard() {
        return getLeaderboard(null, null);
    }
}