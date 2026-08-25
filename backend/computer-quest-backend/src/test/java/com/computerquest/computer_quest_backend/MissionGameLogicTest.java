package com.computerquest.computer_quest_backend;

import com.computerquest.computer_quest_backend.dto.AnswerRequest;
import com.computerquest.computer_quest_backend.dto.AnswerResponse;
import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.service.AuthService;
import com.computerquest.computer_quest_backend.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MissionGameLogicTest {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AuthService authService;

    @Autowired
    private PlayerProgressRepository playerProgressRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    private User testUser;
    private List<Question> mission1Questions;

    @BeforeEach
    public void setup() {
        School school = schoolRepository.findByName("Computer Quest Demo School").orElse(null);
        assertNotNull(school, "Demo school should exist");

        User user = new User();
        user.setUsername("test_student_" + System.currentTimeMillis());
        user.setPassword("pass");
        user.setBoard("STATE_BOARD");
        user.setClassLevel(11);
        user.setSchool(school);
        testUser = authService.register(user);

        // Fetch Mission 1 questions for first chapter
        Chapter firstCh = chapterRepository.findBySchool_IdAndBoardAndClassLevelAndChapterNumber(
                school.getId(), "STATE_BOARD", 11, 1
        ).orElseGet(() -> chapterRepository.findByChapterNumber(1).orElseThrow());

        mission1Questions = questionService.getQuestions(firstCh.getUnit(), firstCh.getChapterName(), 1, null, null, testUser.getId());
        assertTrue(mission1Questions.size() >= 5, "Mission 1 should have at least 5 questions");
    }

    @Test
    public void testFiveCorrectAnswersAwardsFiftyXpAndUnlocksNextMission() {
        PlayerProgress progressBefore = playerProgressRepository.findByUserId(testUser.getId()).orElseThrow();
        assertEquals(0, progressBefore.getXp());
        assertEquals(1, progressBefore.getCurrentMission());
        assertEquals(3, progressBefore.getLives());

        AnswerResponse response = null;
        for (int i = 0; i < 5; i++) {
            Question q = mission1Questions.get(i);
            AnswerRequest request = new AnswerRequest();
            request.setUserId(testUser.getId());
            request.setQuestionId(q.getId());
            request.setAnswer(q.getCorrectAnswer());
            response = questionService.checkAnswer(request);
        }

        assertNotNull(response);
        assertEquals("MISSION_COMPLETE", response.getResult());
        assertEquals(3, response.getLives());
        assertEquals(50, response.getXp());

        PlayerProgress progressAfter = playerProgressRepository.findByUserId(testUser.getId()).orElseThrow();
        assertEquals(50, progressAfter.getXp());
        assertEquals(2, progressAfter.getCurrentMission());
        assertEquals(3, progressAfter.getLives());
    }

    @Test
    public void testFourCorrectOneWrongAwardsFortyXpAndUnlocksNextMission() {
        PlayerProgress progressBefore = playerProgressRepository.findByUserId(testUser.getId()).orElseThrow();
        assertEquals(0, progressBefore.getXp());
        assertEquals(1, progressBefore.getCurrentMission());

        AnswerResponse response = null;
        for (int i = 0; i < 5; i++) {
            Question q = mission1Questions.get(i);
            AnswerRequest request = new AnswerRequest();
            request.setUserId(testUser.getId());
            request.setQuestionId(q.getId());

            if (i == 2) {
                request.setAnswer("WRONG_ANSWER_INCORRECT");
            } else {
                request.setAnswer(q.getCorrectAnswer());
            }

            response = questionService.checkAnswer(request);
        }

        assertNotNull(response);
        assertEquals("MISSION_COMPLETE", response.getResult());
        assertEquals(3, response.getLives());
        assertEquals(40, response.getXp());

        PlayerProgress progressAfter = playerProgressRepository.findByUserId(testUser.getId()).orElseThrow();
        assertEquals(40, progressAfter.getXp());
        assertEquals(2, progressAfter.getCurrentMission());
    }

    @Test
    public void testThreeWrongBeforeFiveQuestionsCausesMissionFailedAndZeroXp() {
        PlayerProgress progressBefore = playerProgressRepository.findByUserId(testUser.getId()).orElseThrow();
        assertEquals(0, progressBefore.getXp());
        assertEquals(1, progressBefore.getCurrentMission());

        // Question 1: Correct (+10 pending)
        Question q1 = mission1Questions.get(0);
        AnswerRequest r1 = new AnswerRequest();
        r1.setUserId(testUser.getId());
        r1.setQuestionId(q1.getId());
        r1.setAnswer(q1.getCorrectAnswer());
        AnswerResponse resp1 = questionService.checkAnswer(r1);
        assertEquals("CORRECT", resp1.getResult());
        assertEquals(3, resp1.getLives());
        assertEquals(0, resp1.getXp());

        // Question 2: Wrong (-1 life -> 2 lives left)
        Question q2 = mission1Questions.get(1);
        AnswerRequest r2 = new AnswerRequest();
        r2.setUserId(testUser.getId());
        r2.setQuestionId(q2.getId());
        r2.setAnswer("WRONG");
        AnswerResponse resp2 = questionService.checkAnswer(r2);
        assertEquals("WRONG", resp2.getResult());
        assertEquals(2, resp2.getLives());

        // Question 3: Wrong (-1 life -> 1 life left)
        Question q3 = mission1Questions.get(2);
        AnswerRequest r3 = new AnswerRequest();
        r3.setUserId(testUser.getId());
        r3.setQuestionId(q3.getId());
        r3.setAnswer("WRONG");
        AnswerResponse resp3 = questionService.checkAnswer(r3);
        assertEquals("WRONG", resp3.getResult());
        assertEquals(1, resp3.getLives());

        // Question 4: Wrong (-1 life -> 0 lives -> MISSION_FAILED)
        Question q4 = mission1Questions.get(3);
        AnswerRequest r4 = new AnswerRequest();
        r4.setUserId(testUser.getId());
        r4.setQuestionId(q4.getId());
        r4.setAnswer("WRONG");
        AnswerResponse resp4 = questionService.checkAnswer(r4);
        assertEquals("MISSION_FAILED", resp4.getResult());
        assertEquals(3, resp4.getLives()); // Restored to 3 lives
        assertEquals(0, resp4.getXp()); // 0 XP committed!

        PlayerProgress progressAfter = playerProgressRepository.findByUserId(testUser.getId()).orElseThrow();
        assertEquals(0, progressAfter.getXp());
        assertEquals(1, progressAfter.getCurrentMission()); // Next mission remains locked
        assertEquals(3, progressAfter.getLives());
    }

    @Test
    public void testRetryServesUnattemptedQuestions() {
        // Submit 4 question attempts
        for (int i = 0; i < 3; i++) {
            Question q = mission1Questions.get(i);
            AnswerRequest request = new AnswerRequest();
            request.setUserId(testUser.getId());
            request.setQuestionId(q.getId());
            request.setAnswer("WRONG");
            questionService.checkAnswer(request);
        }

        // Now request questions for this mission
        Question qFirst = mission1Questions.get(0);
        List<Question> remaining = questionService.getQuestions(
                qFirst.getUnit(), qFirst.getChapter(), qFirst.getMission(), null, null, testUser.getId()
        );

        // Verify remaining questions do not include the 3 attempted questions if unattempted exist
        for (Question rq : remaining) {
            assertNotEquals(mission1Questions.get(0).getId(), rq.getId());
            assertNotEquals(mission1Questions.get(1).getId(), rq.getId());
            assertNotEquals(mission1Questions.get(2).getId(), rq.getId());
        }
    }

    @Test
    public void testAntiFarmingPreventsDuplicateXpForSameQuestion() {
        // Complete mission 1 with 5 correct answers -> +50 XP
        for (int i = 0; i < 5; i++) {
            Question q = mission1Questions.get(i);
            AnswerRequest request = new AnswerRequest();
            request.setUserId(testUser.getId());
            request.setQuestionId(q.getId());
            request.setAnswer(q.getCorrectAnswer());
            questionService.checkAnswer(request);
        }

        PlayerProgress p1 = playerProgressRepository.findByUserId(testUser.getId()).orElseThrow();
        assertEquals(50, p1.getXp());

        // Manually reset current mission back to 1 for test re-attempt
        p1.setCurrentMission(1);
        playerProgressRepository.save(p1);

        // Attempt the exact same 5 questions again in Mission 1
        AnswerResponse finalResp = null;
        for (int i = 0; i < 5; i++) {
            Question q = mission1Questions.get(i);
            AnswerRequest request = new AnswerRequest();
            request.setUserId(testUser.getId());
            request.setQuestionId(q.getId());
            request.setAnswer(q.getCorrectAnswer());
            finalResp = questionService.checkAnswer(request);
        }

        assertNotNull(finalResp);
        assertEquals("MISSION_COMPLETE", finalResp.getResult());
        // Permanent XP should STILL be 50 because no new un-rewarded questions were answered
        assertEquals(50, finalResp.getXp());
    }
}
