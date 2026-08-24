package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerProgressRepository extends JpaRepository<PlayerProgress, Long> {

    Optional<PlayerProgress> findByUserId(Long userId);

    List<PlayerProgress> findAllByOrderByXpDesc();

    List<PlayerProgress> findByUser_School_IdOrderByXpDesc(Long schoolId);
}