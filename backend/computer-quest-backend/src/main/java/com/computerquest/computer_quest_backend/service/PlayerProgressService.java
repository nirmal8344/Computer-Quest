    package com.computerquest.computer_quest_backend.service;

    import com.computerquest.computer_quest_backend.entity.PlayerProgress;
    import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class PlayerProgressService {

        private final PlayerProgressRepository playerProgressRepository;

        public PlayerProgressService(PlayerProgressRepository playerProgressRepository) {
            this.playerProgressRepository = playerProgressRepository;
        }

        public PlayerProgress saveProgress(PlayerProgress progress) {
            return playerProgressRepository.save(progress);
        }

        public List<PlayerProgress> getAllProgress() {
            return playerProgressRepository.findAll();
        }
    }