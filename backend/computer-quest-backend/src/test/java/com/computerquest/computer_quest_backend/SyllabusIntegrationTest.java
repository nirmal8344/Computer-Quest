package com.computerquest.computer_quest_backend;

import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.service.ChapterService;
import com.computerquest.computer_quest_backend.service.MissionService;
import com.computerquest.computer_quest_backend.service.QuestionService;
import com.computerquest.computer_quest_backend.service.UnitService;
import com.computerquest.computer_quest_backend.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SyllabusIntegrationTest {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private MissionService missionService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AuthService authService;

    @Autowired
    private SchoolRepository schoolRepository;

    @Test
    public void testDemoSchoolStateBoardClass11Syllabus() {
        School school = schoolRepository.findByName("Computer Quest Demo School").orElse(null);
        assertNotNull(school, "Demo school should exist");

        User user = new User();
        user.setUsername("student_demo_11_" + System.currentTimeMillis());
        user.setPassword("pass");
        user.setBoard("STATE_BOARD");
        user.setClassLevel(11);
        user.setSchool(school);
        User saved = authService.register(user);

        // Check Units
        List<Unit> units = unitService.getUnits(null, null, saved.getId(), null, null);
        assertEquals(5, units.size(), "Class 11 must have exactly 5 units");

        // Check Chapters
        List<Chapter> chapters = chapterService.getChapters(null, null, saved.getId(), null, null);
        assertEquals(18, chapters.size(), "Class 11 must have exactly 18 chapters");

        // Check Missions
        List<Mission> missions = missionService.getMissions(null, null, saved.getId(), null, null);
        assertEquals(72, missions.size(), "Class 11 must have 18 * 4 = 72 missions");

        // Test first chapter's 4 missions and 5 questions per mission
        Chapter firstCh = chapters.get(0);
        for (int mNum = 1; mNum <= 4; mNum++) {
            List<Question> questions = questionService.getQuestions(firstCh.getUnit(), firstCh.getChapterName(), mNum, null, null, saved.getId());
            assertEquals(5, questions.size(), "Mission " + mNum + " should have 5 questions");
        }
    }

    @Test
    public void testDemoSchoolStateBoardClass12Syllabus() {
        School school = schoolRepository.findByName("Computer Quest Demo School").orElse(null);
        assertNotNull(school, "Demo school should exist");

        User user = new User();
        user.setUsername("student_demo_12_" + System.currentTimeMillis());
        user.setPassword("pass");
        user.setBoard("STATE_BOARD");
        user.setClassLevel(12);
        user.setSchool(school);
        User saved = authService.register(user);

        // Check Units
        List<Unit> units = unitService.getUnits(null, null, saved.getId(), null, null);
        assertEquals(5, units.size(), "Class 12 must have exactly 5 units");

        // Check Chapters
        List<Chapter> chapters = chapterService.getChapters(null, null, saved.getId(), null, null);
        assertEquals(16, chapters.size(), "Class 12 must have exactly 16 chapters");

        // Check Missions
        List<Mission> missions = missionService.getMissions(null, null, saved.getId(), null, null);
        assertEquals(64, missions.size(), "Class 12 must have 16 * 4 = 64 missions");

        // Test first chapter's 4 missions and 5 questions per mission
        Chapter firstCh = chapters.get(0);
        for (int mNum = 1; mNum <= 4; mNum++) {
            List<Question> questions = questionService.getQuestions(firstCh.getUnit(), firstCh.getChapterName(), mNum, null, null, saved.getId());
            assertEquals(5, questions.size(), "Mission " + mNum + " should have 5 questions");
        }
    }
}
