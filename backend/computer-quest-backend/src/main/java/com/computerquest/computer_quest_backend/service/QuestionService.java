package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.dto.AnswerRequest;
import com.computerquest.computer_quest_backend.dto.AnswerResponse;
import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.entity.QuestionAttempt;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.QuestionAttemptRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final PlayerProgressRepository playerProgressRepository;
    private final UserRepository userRepository;
    private final QuestionAttemptRepository questionAttemptRepository;
    private final ChapterRepository chapterRepository;
    private final SchoolRepository schoolRepository;
    private final AdminRepository adminRepository;

    public QuestionService(
            QuestionRepository questionRepository,
            PlayerProgressRepository playerProgressRepository,
            UserRepository userRepository,
            QuestionAttemptRepository questionAttemptRepository,
            ChapterRepository chapterRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository) {

        this.questionRepository = questionRepository;
        this.playerProgressRepository = playerProgressRepository;
        this.userRepository = userRepository;
        this.questionAttemptRepository = questionAttemptRepository;
        this.chapterRepository = chapterRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
    }

    // Save question
    public Question saveQuestion(Question question) {
        resolveSchool(question);
        if (question.getId() == null) {
            Long schoolId = question.getSchool() != null ? question.getSchool().getId() : question.getSchoolId();
            List<Question> existing = getQuestions(
                    question.getUnit(),
                    question.getChapter(),
                    question.getMission(),
                    question.getBoard(),
                    question.getClassLevel(),
                    null,
                    null,
                    schoolId
            );
            if (existing != null && existing.size() >= 5) {
                throw new RuntimeException("Maximum 5 questions allowed per mission.");
            }
        }
        return questionRepository.save(question);
    }

    private void resolveSchool(Question question) {
        if (question.getSchool() != null && question.getSchool().getId() != null) {
            question.setSchool(schoolRepository.findById(question.getSchool().getId()).orElse(null));
        } else if (question.getSchoolId() != null) {
            question.setSchool(schoolRepository.findById(question.getSchoolId()).orElse(null));
        } else if (question.getSchoolName() != null && !question.getSchoolName().trim().isEmpty()) {
            String name = question.getSchoolName().trim();
            question.setSchool(schoolRepository.findByName(name).orElseGet(() -> schoolRepository.save(new School(name))));
        } else if (question.getAdminId() != null) {
            Admin admin = adminRepository.findById(question.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                question.setSchool(admin.getSchool());
            }
        }
    }

    // Get questions based on Unit + Chapter + Mission
    public List<Question> getQuestions(
            String unit,
            String chapter,
            Integer mission) {

        return getQuestions(unit, chapter, mission, null, null, null, null, null);
    }

    public List<Question> getQuestions(
            String unit,
            String chapter,
            Integer mission,
            String board,
            Integer classLevel,
            Long userId) {

        return getQuestions(unit, chapter, mission, board, classLevel, userId, null, null);
    }

    // Get questions with school, board, classLevel, userId, adminId, or schoolId filtering
    public List<Question> getQuestions(
            String unit,
            String chapter,
            Integer mission,
            String board,
            Integer classLevel,
            Long userId,
            Long adminId,
            Long schoolId) {

        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                Long adminSchoolId = admin.getSchool().getId();
                return questionRepository.findBySchool_IdAndUnitAndChapterAndMission(adminSchoolId, unit, chapter, mission);
            }
        }

        if (userId != null) {
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                board = user.getBoard();
                classLevel = user.getClassLevel();
                if (user.getSchool() != null) {
                    schoolId = user.getSchool().getId();
                }
            }
        }

        List<Question> rawResult;
        if (schoolId != null) {
            if (board != null && classLevel != null) {
                List<Question> schoolQuestions = questionRepository.findBySchool_IdAndBoardAndClassLevelAndUnitAndChapterAndMission(
                        schoolId, board, classLevel, unit, chapter, mission
                );
                if (!schoolQuestions.isEmpty()) {
                    rawResult = schoolQuestions;
                    return filterUnattemptedIfAvailable(rawResult, userId);
                }
            }
            List<Question> schoolQuestions = questionRepository.findBySchool_IdAndUnitAndChapterAndMission(
                    schoolId, unit, chapter, mission
            );
            if (!schoolQuestions.isEmpty()) {
                rawResult = schoolQuestions;
                return filterUnattemptedIfAvailable(rawResult, userId);
            }
            // Fallback to global seeded questions (school IS NULL) - NEVER return another school's questions!
            if (board != null && classLevel != null) {
                rawResult = questionRepository.findBySchoolIsNullAndBoardAndClassLevelAndUnitAndChapterAndMission(
                        board, classLevel, unit, chapter, mission
                );
                return filterUnattemptedIfAvailable(rawResult, userId);
            }
            rawResult = questionRepository.findBySchoolIsNullAndUnitAndChapterAndMission(unit, chapter, mission);
            return filterUnattemptedIfAvailable(rawResult, userId);
        }

        if (board != null && classLevel != null) {
            List<Question> filtered = questionRepository.findBySchoolIsNullAndBoardAndClassLevelAndUnitAndChapterAndMission(
                    board, classLevel, unit, chapter, mission
            );
            if (!filtered.isEmpty()) {
                rawResult = filtered;
                return filterUnattemptedIfAvailable(rawResult, userId);
            }
        }

        rawResult = questionRepository.findBySchoolIsNullAndUnitAndChapterAndMission(
                unit,
                chapter,
                mission
        );
        return filterUnattemptedIfAvailable(rawResult, userId);
    }

    private List<Question> filterUnattemptedIfAvailable(List<Question> rawQuestions, Long userId) {
        if (userId == null || rawQuestions == null || rawQuestions.isEmpty()) {
            return rawQuestions;
        }
        List<QuestionAttempt> attempts = questionAttemptRepository.findByUser_Id(userId);
        if (attempts.isEmpty()) {
            return rawQuestions;
        }
        java.util.Set<Long> attemptedIds = attempts.stream()
                .map(a -> a.getQuestion() != null ? a.getQuestion().getId() : null)
                .filter(java.util.Objects::nonNull)
                .collect(java.util.stream.Collectors.toSet());

        List<Question> unattempted = rawQuestions.stream()
                .filter(q -> !attemptedIds.contains(q.getId()))
                .collect(java.util.stream.Collectors.toList());

        return !unattempted.isEmpty() ? unattempted : rawQuestions;
    }

    // Update question
    public Question updateQuestion(Long id, Question question) {

        Question existingQuestion = questionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Question not found"));

        question.setId(existingQuestion.getId());

        return questionRepository.save(question);
    }

    // Delete question
    public void deleteQuestion(Long id) {

        if (!questionRepository.existsById(id)) {
            throw new RuntimeException("Question not found");
        }

        questionRepository.deleteById(id);
    }

    // Check submitted answer
    public AnswerResponse checkAnswer(AnswerRequest request) {

        // 1. Find question
        Question question = questionRepository
                .findById(request.getQuestionId())
                .orElseThrow(() ->
                        new RuntimeException("Question not found"));

        // 2. Find user
        User user = userRepository
                .findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // 3. Find player progress
        PlayerProgress progress = playerProgressRepository
                .findByUserId(user.getId())
                .orElseThrow(() ->
                        new RuntimeException("Player progress not found"));

        // 4. Fix old NULL values
        if (progress.getAnsweredQuestions() == null) {
            progress.setAnsweredQuestions(0);
        }

        if (progress.getLives() == null) {
            progress.setLives(3);
        }

        if (progress.getXp() == null) {
            progress.setXp(0);
        }

        if (progress.getCurrentChapter() == null) {
            progress.setCurrentChapter(1);
        }

        if (progress.getCurrentMission() == null) {
            progress.setCurrentMission(1);
        }

        // 5. Check answer
        boolean correct = isAnswerCorrect(question, request.getAnswer());

        // 6. Save question attempt
        QuestionAttempt attempt = new QuestionAttempt();

        attempt.setUser(user);
        attempt.setQuestion(question);
        attempt.setCorrect(correct);

        questionAttemptRepository.save(attempt);

        // 7. Increase answered question count
        progress.setAnsweredQuestions(
                progress.getAnsweredQuestions() + 1
        );

        // 8. Correct / Wrong
        if (correct) {

            // Correct answer → +10 XP
            progress.setXp(
                    progress.getXp() + 10
            );

        } else {

            // Wrong answer → -1 Life
            progress.setLives(
                    progress.getLives() - 1
            );
        }

        // 9. Mission failed
        if (progress.getLives() <= 0) {

            progress.setLives(3);
            progress.setAnsweredQuestions(0);

            playerProgressRepository.save(progress);

            return new AnswerResponse(
                    "MISSION_FAILED",
                    progress.getLives(),
                    progress.getXp()
            );
        }

        // 10. Five questions completed
        if (progress.getAnsweredQuestions() >= 5) {

            int completedMission =
                    progress.getCurrentMission();

            // 11. Mission 4 completed
            if (completedMission == 4) {

                int currentChapter =
                        progress.getCurrentChapter();

                Long userSchoolId = user.getSchool() != null ? user.getSchool().getId() : null;

                // Current chapter matching user school, board & class
                Chapter currentChapterEntity = null;
                if (userSchoolId != null) {
                    currentChapterEntity = chapterRepository
                            .findBySchool_IdAndBoardAndClassLevelAndChapterNumber(
                                    userSchoolId, user.getBoard(), user.getClassLevel(), currentChapter
                            )
                            .orElse(null);
                }
                if (currentChapterEntity == null) {
                    currentChapterEntity = chapterRepository
                            .findBySchoolIsNullAndBoardAndClassLevelAndChapterNumber(
                                    user.getBoard(), user.getClassLevel(), currentChapter
                            )
                            .orElseGet(() -> chapterRepository.findByChapterNumber(currentChapter).orElse(null));
                }

                if (currentChapterEntity != null) {
                    currentChapterEntity.setUnlocked(true);
                    chapterRepository.save(currentChapterEntity);
                }

                // Unlock next chapter matching user school, board & class
                Chapter nextChapter = null;
                if (userSchoolId != null) {
                    nextChapter = chapterRepository
                            .findBySchool_IdAndBoardAndClassLevelAndChapterNumber(
                                    userSchoolId, user.getBoard(), user.getClassLevel(), currentChapter + 1
                            )
                            .orElse(null);
                }
                if (nextChapter == null) {
                    nextChapter = chapterRepository
                            .findBySchoolIsNullAndBoardAndClassLevelAndChapterNumber(
                                    user.getBoard(), user.getClassLevel(), currentChapter + 1
                            )
                            .orElseGet(() -> chapterRepository.findByChapterNumber(currentChapter + 1).orElse(null));
                }

                if (nextChapter != null) {

                    nextChapter.setUnlocked(true);

                    chapterRepository.save(
                            nextChapter
                    );

                    // Move player to next chapter
                    progress.setCurrentChapter(
                            currentChapter + 1
                    );

                    progress.setCurrentMission(1);
                }

            } else {

                // Mission 1 → 2
                // Mission 2 → 3
                // Mission 3 → 4
                progress.setCurrentMission(
                        completedMission + 1
                );
            }

            // Reset for next mission/chapter
            progress.setAnsweredQuestions(0);
            progress.setLives(3);

            playerProgressRepository.save(progress);

            return new AnswerResponse(
                    "MISSION_COMPLETE",
                    progress.getLives(),
                    progress.getXp()
            );
        }

        // 12. Save normal progress
        playerProgressRepository.save(progress);

        // 13. Return result
        return new AnswerResponse(
                correct ? "CORRECT" : "WRONG",
                progress.getLives(),
                progress.getXp()
        );
    }

    private boolean isAnswerCorrect(Question q, String userAns) {
        if (userAns == null || userAns.trim().isEmpty()) {
            return false;
        }
        String submitted = userAns.trim();
        String target = q.getCorrectAnswer() != null ? q.getCorrectAnswer().trim() : "";

        if (submitted.equalsIgnoreCase(target)) {
            return true;
        }

        String normSubmitted = normalizeAnswer(submitted);
        String normTarget = normalizeAnswer(target);
        if (!normTarget.isEmpty() && normSubmitted.equalsIgnoreCase(normTarget)) {
            return true;
        }

        java.util.List<String> acceptedList = new java.util.ArrayList<>();
        if (target.contains(",")) {
            for (String s : target.split(",")) {
                acceptedList.add(s.trim());
            }
        }
        if (q.getOptionB() != null && !q.getOptionB().trim().isEmpty() && !q.getQuestionType().equals("MCQ")) {
            for (String s : q.getOptionB().split(",")) {
                acceptedList.add(s.trim());
            }
        }

        for (String acc : acceptedList) {
            if (submitted.equalsIgnoreCase(acc) || normSubmitted.equalsIgnoreCase(normalizeAnswer(acc))) {
                return true;
            }
        }
        return false;
    }

    private String normalizeAnswer(String text) {
        if (text == null) return "";
        return text.replaceAll("\\s+", " ").trim().toLowerCase();
    }
}