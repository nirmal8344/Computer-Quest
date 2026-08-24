package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.QuestionAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionAttemptRepository extends JpaRepository<QuestionAttempt, Long> {

    List<QuestionAttempt> findByUser_Id(Long userId);

}