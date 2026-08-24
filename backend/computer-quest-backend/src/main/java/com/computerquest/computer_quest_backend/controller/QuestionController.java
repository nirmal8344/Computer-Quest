package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.dto.AnswerRequest;
import com.computerquest.computer_quest_backend.dto.AnswerResponse;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @GetMapping
    public List<Question> getQuestions(
            @RequestParam String unit,
            @RequestParam String chapter,
            @RequestParam Integer mission,
            @RequestParam(required = false) String board,
            @RequestParam(required = false) Integer classLevel,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long adminId,
            @RequestParam(required = false) Long schoolId) {

        return questionService.getQuestions(unit, chapter, mission, board, classLevel, userId, adminId, schoolId);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(
            @PathVariable Long id,
            @RequestBody Question question) {

        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {

        questionService.deleteQuestion(id);

        return "Question deleted successfully";
    }

    @PostMapping("/answer")
    public AnswerResponse checkAnswer(
            @RequestBody AnswerRequest request) {

        return questionService.checkAnswer(request);
    }
}