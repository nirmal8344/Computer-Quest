package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.dto.GameResponse;
import com.computerquest.computer_quest_backend.dto.SubjectProgressDto;
import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.Subject;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import com.computerquest.computer_quest_backend.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {

    private final UserRepository userRepository;
    private final PlayerProgressRepository playerProgressRepository;
    private final SubjectService subjectService;

    public GameController(
            UserRepository userRepository,
            PlayerProgressRepository playerProgressRepository,
            SubjectService subjectService) {

        this.userRepository = userRepository;
        this.playerProgressRepository = playerProgressRepository;
        this.subjectService = subjectService;
    }

    @GetMapping("/{userId}")
    public GameResponse getGameData(
            @PathVariable Long userId,
            @RequestParam(required = false) String subject) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // Fetch all available subjects for this student
        List<Subject> availableSubjects = subjectService.getSubjects(
                user.getBoard(),
                user.getClassLevel(),
                user.getId(),
                null,
                user.getSchool() != null ? user.getSchool().getId() : null
        );

        // Fetch all existing subject progresses for this student
        List<PlayerProgress> userProgresses = playerProgressRepository.findAllByUserId(userId);
        Map<String, PlayerProgress> progressMap = userProgresses.stream()
                .filter(p -> p.getSubject() != null)
                .collect(Collectors.toMap(
                        p -> p.getSubject().trim().toLowerCase(),
                        p -> p,
                        (existing, replacement) -> existing
                ));

        List<SubjectProgressDto> subjectDtos = new ArrayList<>();
        int totalXp = 0;

        for (Subject sub : availableSubjects) {
            String key = sub.getSubjectName().trim().toLowerCase();
            PlayerProgress p = progressMap.get(key);
            if (p == null) {
                // Initialize default progress for this subject
                p = new PlayerProgress(user, sub.getSubjectName());
                p = playerProgressRepository.save(p);
            }
            int subXp = p.getXp() != null ? p.getXp() : 0;
            totalXp += subXp;

            subjectDtos.add(new SubjectProgressDto(
                    sub.getSubjectName(),
                    sub.getSubjectCode(),
                    sub.getIcon(),
                    sub.getColor(),
                    p.getCurrentChapter() != null ? p.getCurrentChapter() : 1,
                    p.getCurrentMission() != null ? p.getCurrentMission() : 1,
                    subXp,
                    p.getLives() != null ? p.getLives() : 3
            ));
        }

        // Active / Current subject progress
        String activeSubject = (subject != null && !subject.trim().isEmpty())
                ? subject.trim()
                : (!availableSubjects.isEmpty() ? availableSubjects.get(0).getSubjectName() : "General");

        PlayerProgress currentProgress = progressMap.get(activeSubject.toLowerCase());
        if (currentProgress == null) {
            if (!userProgresses.isEmpty()) {
                currentProgress = userProgresses.get(0);
            } else {
                currentProgress = playerProgressRepository.save(new PlayerProgress(user, activeSubject));
            }
        }

        return new GameResponse(
                user.getId(),
                user.getUsername(),
                currentProgress.getCurrentChapter() != null ? currentProgress.getCurrentChapter() : 1,
                currentProgress.getCurrentMission() != null ? currentProgress.getCurrentMission() : 1,
                currentProgress.getLives() != null ? currentProgress.getLives() : 3,
                totalXp,
                totalXp,
                user.getStreakDays(),
                activeSubject,
                user.getBoard(),
                user.getClassLevel(),
                user.getStudentGroup(),
                user.getSchool(),
                subjectDtos
        );
    }
}