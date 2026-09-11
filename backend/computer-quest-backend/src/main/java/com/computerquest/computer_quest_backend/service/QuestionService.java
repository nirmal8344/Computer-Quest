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
import com.computerquest.computer_quest_backend.entity.UserQuestionReward;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.QuestionAttemptRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UserQuestionRewardRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    private final UserQuestionRewardRepository userQuestionRewardRepository;

    public QuestionService(
            QuestionRepository questionRepository,
            PlayerProgressRepository playerProgressRepository,
            UserRepository userRepository,
            QuestionAttemptRepository questionAttemptRepository,
            ChapterRepository chapterRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository,
            UserQuestionRewardRepository userQuestionRewardRepository) {

        this.questionRepository = questionRepository;
        this.playerProgressRepository = playerProgressRepository;
        this.userRepository = userRepository;
        this.questionAttemptRepository = questionAttemptRepository;
        this.chapterRepository = chapterRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
        this.userQuestionRewardRepository = userQuestionRewardRepository;
    }

    // Save question
    public Question saveQuestion(Question question) {
        resolveSchool(question);
        if (question.getId() == null) {
            Long schoolId = question.getSchool() != null ? question.getSchool().getId() : question.getSchoolId();
            List<Question> existing = getQuestions(
                    question.getSubject(),
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

    // Overloads for getQuestions
    public List<Question> getQuestions(String unit, String chapter, Integer mission) {
        return getQuestions(null, unit, chapter, mission, null, null, null, null, null);
    }

    public List<Question> getQuestions(String unit, String chapter, Integer mission, String board, Integer classLevel, Long userId) {
        return getQuestions(null, unit, chapter, mission, board, classLevel, userId, null, null);
    }

    public List<Question> getQuestions(
            String subject,
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
                if (subject != null && !subject.trim().isEmpty()) {
                    return questionRepository.findBySchool_IdAndBoardAndClassLevelAndSubjectAndUnitAndChapterAndMission(
                            adminSchoolId, board, classLevel, subject.trim(), unit, chapter, mission
                    );
                }
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

                // Reset temporary in-flight state for active subject
                PlayerProgress progress = getOrCreateProgress(user, subject);
                progress.setAnsweredQuestions(0);
                progress.setPendingXp(0);
                progress.setLives(3);
                playerProgressRepository.save(progress);
            }
        }

        List<Question> rawResult = List.of();

        // 1. With Subject & School
        if (schoolId != null) {
            if (board != null && classLevel != null && subject != null && !subject.trim().isEmpty()) {
                rawResult = questionRepository.findBySchool_IdAndBoardAndClassLevelAndSubjectAndUnitAndChapterAndMission(
                        schoolId, board, classLevel, subject.trim(), unit, chapter, mission
                );
            }
            if (rawResult.isEmpty() && board != null && classLevel != null) {
                rawResult = questionRepository.findBySchool_IdAndBoardAndClassLevelAndUnitAndChapterAndMission(
                        schoolId, board, classLevel, unit, chapter, mission
                );
            }
            if (rawResult.isEmpty()) {
                rawResult = questionRepository.findBySchool_IdAndUnitAndChapterAndMission(schoolId, unit, chapter, mission);
            }
        }

        // 2. With Subject (Base/Global)
        if (rawResult.isEmpty() && board != null && classLevel != null && subject != null && !subject.trim().isEmpty()) {
            rawResult = questionRepository.findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndUnitAndChapterAndMission(
                    board, classLevel, subject.trim(), unit, chapter, mission
            );
        }

        // 3. Without Subject (Fallback to Board/Class/Unit/Chapter/Mission Base/Global)
        if (rawResult.isEmpty() && board != null && classLevel != null) {
            rawResult = questionRepository.findBySchoolIsNullAndBoardAndClassLevelAndUnitAndChapterAndMission(
                    board, classLevel, unit, chapter, mission
            );
        }

        // 4. Base/Global Unit/Chapter/Mission Fallback
        if (rawResult.isEmpty()) {
            if (subject != null && !subject.trim().isEmpty()) {
                rawResult = questionRepository.findBySchoolIsNullAndSubjectAndUnitAndChapterAndMission(subject.trim(), unit, chapter, mission);
            }
            if (rawResult.isEmpty()) {
                rawResult = questionRepository.findBySchoolIsNullAndUnitAndChapterAndMission(unit, chapter, mission);
            }
        }

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
        Question existing = questionRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        if (question.getAdminId() != null) {
            Admin admin = adminRepository.findById(question.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot modify question of another school.");
                }
            }
        }

        question.setId(existing.getId());
        resolveSchool(question);
        return questionRepository.save(question);
    }

    // Delete question
    public void deleteQuestion(Long id) {
        deleteQuestion(id, null);
    }

    public void deleteQuestion(Long id, Long adminId) {
        Question existing = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null && existing.getSchool() != null) {
                if (!admin.getSchool().getId().equals(existing.getSchool().getId())) {
                    throw new RuntimeException("Unauthorized: Cannot delete question of another school.");
                }
            }
        }

        questionRepository.deleteById(id);
    }

    public PlayerProgress getOrCreateProgress(User user, String subject) {
        if (subject != null && !subject.trim().isEmpty()) {
            return playerProgressRepository.findByUserIdAndSubject(user.getId(), subject.trim())
                    .orElseGet(() -> playerProgressRepository.save(new PlayerProgress(user, subject.trim())));
        }
        return playerProgressRepository.findByUserId(user.getId())
                .orElseGet(() -> playerProgressRepository.save(new PlayerProgress(user, "General")));
    }

    // Check submitted answer
    @Transactional
    public AnswerResponse checkAnswer(AnswerRequest request) {
        // 1. Find question
        Question question = questionRepository
                .findById(request.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // 2. Find user
        User user = userRepository
                .findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update streak
        updateUserStreak(user);

        // 3. Find or create player progress for this subject
        String subject = (request.getSubject() != null && !request.getSubject().trim().isEmpty())
                ? request.getSubject().trim()
                : (question.getSubject() != null && !question.getSubject().trim().isEmpty())
                ? question.getSubject().trim()
                : "General";

        PlayerProgress progress = getOrCreateProgress(user, subject);

        // Fix nulls
        if (progress.getAnsweredQuestions() == null) progress.setAnsweredQuestions(0);
        if (progress.getLives() == null) progress.setLives(3);
        if (progress.getXp() == null) progress.setXp(0);
        if (progress.getPendingXp() == null) progress.setPendingXp(0);
        if (progress.getCurrentChapter() == null) progress.setCurrentChapter(1);
        if (progress.getCurrentMission() == null) progress.setCurrentMission(1);

        // 4. Check answer correctness
        boolean correct = isAnswerCorrect(question, request.getAnswer());

        // 5. Save question attempt
        QuestionAttempt attempt = new QuestionAttempt();
        attempt.setUser(user);
        attempt.setQuestion(question);
        attempt.setCorrect(correct);
        questionAttemptRepository.save(attempt);

        // 6. Increase answered question count
        progress.setAnsweredQuestions(progress.getAnsweredQuestions() + 1);

        // 7. Pending XP / Lives handling
        if (correct) {
            boolean alreadyRewarded = userQuestionRewardRepository.existsByUserIdAndQuestionId(user.getId(), question.getId());
            if (!alreadyRewarded) {
                progress.setPendingXp(progress.getPendingXp() + 10);
            }
        } else {
            progress.setLives(progress.getLives() - 1);
        }

        // Calculate current total XP across all user's subjects
        int totalXp = calculateTotalXp(user.getId(), progress);

        // 8. Mission failed
        if (progress.getLives() <= 0) {
            progress.setPendingXp(0);
            progress.setLives(3);
            progress.setAnsweredQuestions(0);
            playerProgressRepository.save(progress);

            return new AnswerResponse(
                    "MISSION_FAILED",
                    progress.getLives(),
                    progress.getXp(),
                    totalXp,
                    user.getStreakDays()
            );
        }

        // 9. Mission success (5 questions completed)
        if (progress.getAnsweredQuestions() >= 5) {
            progress.setXp(progress.getXp() + progress.getPendingXp());

            // Reward tracking
            List<QuestionAttempt> attempts = questionAttemptRepository.findByUser_Id(user.getId());
            int startIdx = Math.max(0, attempts.size() - 5);
            for (int i = startIdx; i < attempts.size(); i++) {
                QuestionAttempt qa = attempts.get(i);
                if (Boolean.TRUE.equals(qa.getCorrect()) && qa.getQuestion() != null) {
                    Long qId = qa.getQuestion().getId();
                    if (!userQuestionRewardRepository.existsByUserIdAndQuestionId(user.getId(), qId)) {
                        userQuestionRewardRepository.save(new UserQuestionReward(user, qa.getQuestion()));
                    }
                }
            }

            int completedMission = progress.getCurrentMission();

            if (completedMission == 4) {
                int currentChapter = progress.getCurrentChapter();
                Long userSchoolId = user.getSchool() != null ? user.getSchool().getId() : null;

                Chapter nextChapter = null;
                if (userSchoolId != null) {
                    nextChapter = chapterRepository
                            .findBySchool_IdAndBoardAndClassLevelAndSubjectAndChapterNumber(
                                    userSchoolId, user.getBoard(), user.getClassLevel(), subject, currentChapter + 1
                            )
                            .orElse(null);
                }
                if (nextChapter == null) {
                    nextChapter = chapterRepository
                            .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(
                                    user.getBoard(), user.getClassLevel(), subject, currentChapter + 1
                            )
                            .orElseGet(() -> chapterRepository.findByBoardAndClassLevelAndChapterNumber(
                                    user.getBoard(), user.getClassLevel(), currentChapter + 1
                            ).orElse(null));
                }

                if (nextChapter != null) {
                    nextChapter.setUnlocked(true);
                    chapterRepository.save(nextChapter);
                    progress.setCurrentChapter(currentChapter + 1);
                    progress.setCurrentMission(1);
                }
            } else {
                progress.setCurrentMission(completedMission + 1);
            }

            progress.setPendingXp(0);
            progress.setAnsweredQuestions(0);
            progress.setLives(3);

            playerProgressRepository.save(progress);
            totalXp = calculateTotalXp(user.getId(), progress);

            return new AnswerResponse(
                    "MISSION_COMPLETE",
                    progress.getLives(),
                    progress.getXp(),
                    totalXp,
                    user.getStreakDays()
            );
        }

        // 10. Normal Answer Save
        playerProgressRepository.save(progress);
        totalXp = calculateTotalXp(user.getId(), progress);

        return new AnswerResponse(
                correct ? "CORRECT" : "WRONG",
                progress.getLives(),
                progress.getXp(),
                totalXp,
                user.getStreakDays()
        );
    }

    private void updateUserStreak(User user) {
        LocalDate today = LocalDate.now();
        LocalDate lastActive = user.getLastActiveDate();

        if (lastActive == null) {
            user.setStreakDays(1);
            user.setLastActiveDate(today);
            userRepository.save(user);
        } else if (!lastActive.equals(today)) {
            if (lastActive.plusDays(1).equals(today)) {
                user.setStreakDays(user.getStreakDays() + 1);
            } else {
                user.setStreakDays(1);
            }
            user.setLastActiveDate(today);
            userRepository.save(user);
        }
    }

    private int calculateTotalXp(Long userId, PlayerProgress currentSubjectProgress) {
        List<PlayerProgress> allProgress = playerProgressRepository.findAllByUserId(userId);
        int total = 0;
        boolean currentFound = false;
        for (PlayerProgress p : allProgress) {
            if (p.getId() != null && p.getId().equals(currentSubjectProgress.getId())) {
                total += (currentSubjectProgress.getXp() != null ? currentSubjectProgress.getXp() : 0);
                currentFound = true;
            } else {
                total += (p.getXp() != null ? p.getXp() : 0);
            }
        }
        if (!currentFound && currentSubjectProgress.getXp() != null) {
            total += currentSubjectProgress.getXp();
        }
        return total;
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