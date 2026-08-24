package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.QuestionAttempt;
import com.computerquest.computer_quest_backend.repository.QuestionAttemptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAttemptService {

    private final QuestionAttemptRepository questionAttemptRepository;

    public QuestionAttemptService(
            QuestionAttemptRepository questionAttemptRepository) {
        this.questionAttemptRepository = questionAttemptRepository;
    }

    public QuestionAttempt saveAttempt(QuestionAttempt attempt) {
        return questionAttemptRepository.save(attempt);
    }

    public List<QuestionAttempt> getAllAttempts() {
        return questionAttemptRepository.findAll();
    }
}