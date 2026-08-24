package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.QuestionAttempt;
import com.computerquest.computer_quest_backend.service.QuestionAttemptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attempts")
@CrossOrigin
public class QuestionAttemptController {

    private final QuestionAttemptService questionAttemptService;

    public QuestionAttemptController(
            QuestionAttemptService questionAttemptService) {
        this.questionAttemptService = questionAttemptService;
    }

    @PostMapping
    public QuestionAttempt createAttempt(@RequestBody QuestionAttempt attempt) {
        return questionAttemptService.saveAttempt(attempt);
    }

    @GetMapping
    public List<QuestionAttempt> getAllAttempts() {
        return questionAttemptService.getAllAttempts();
    }
}