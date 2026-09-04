const fs = require('fs');
const path = require('path');

const targetJavaFile = "c:\\Users\\ADMIN\\OneDrive\\Documents\\Computer-Quest\\backend\\computer-quest-backend\\src\\main\\java\\com\\computerquest\\computer_quest_backend\\config\\Class4To10SyllabusSeeder.java";

// Build the full Java file
let code = `package com.computerquest.computer_quest_backend.config;

import com.computerquest.computer_quest_backend.entity.*;
import com.computerquest.computer_quest_backend.repository.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Class4To10SyllabusSeeder {

    private final SchoolRepository schoolRepository;
    private final UnitRepository unitRepository;
    private final ChapterRepository chapterRepository;
    private final MissionRepository missionRepository;
    private final QuestionRepository questionRepository;
    private final SchoolClassRepository schoolClassRepository;

    public Class4To10SyllabusSeeder(
            SchoolRepository schoolRepository,
            UnitRepository unitRepository,
            ChapterRepository chapterRepository,
            MissionRepository missionRepository,
            QuestionRepository questionRepository,
            SchoolClassRepository schoolClassRepository) {
        this.schoolRepository = schoolRepository;
        this.unitRepository = unitRepository;
        this.chapterRepository = chapterRepository;
        this.missionRepository = missionRepository;
        this.questionRepository = questionRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    public void seedClasses4To10() {
        School demoSchool = schoolRepository.findByName("Computer Quest Demo School").orElseGet(() ->
                schoolRepository.save(new School("Computer Quest Demo School")));

        // 1. Ensure SchoolClasses exist for Classes 4 to 10 in both CBSE and STATE_BOARD
        seedSchoolClasses(demoSchool);

        // 2. Seed CBSE Curriculum for Classes 4 to 10
        seedCbseClass4(demoSchool);
        seedCbseClass5(demoSchool);
        seedCbseClass6(demoSchool);
        seedCbseClass7(demoSchool);
        seedCbseClass8(demoSchool);
        seedCbseClass9(demoSchool);
        seedCbseClass10(demoSchool);

        // 3. Seed Tamil Nadu State Board Curriculum for Classes 4 to 10
        seedStateBoardClass4(demoSchool);
        seedStateBoardClass5(demoSchool);
        seedStateBoardClass6(demoSchool);
        seedStateBoardClass7(demoSchool);
        seedStateBoardClass8(demoSchool);
        seedStateBoardClass9(demoSchool);
        seedStateBoardClass10(demoSchool);
    }

    private void seedSchoolClasses(School demoSchool) {
        String[] boards = {"CBSE", "STATE_BOARD"};
        for (String board : boards) {
            for (int lvl = 4; lvl <= 10; lvl++) {
                final int finalLvl = lvl;
                final String finalBoard = board;
                boolean exists = schoolClassRepository.findBySchool_IdAndBoardAndClassLevel(demoSchool.getId(), finalBoard, finalLvl).isPresent();
                if (!exists) {
                    schoolClassRepository.save(new SchoolClass(finalLvl + "th Standard", finalLvl, finalBoard, demoSchool));
                }
            }
        }
    }

    private Unit getOrCreateUnit(School school, String board, int classLevel, int unitNumber, String unitName) {
        List<Unit> units = (school != null)
                ? unitRepository.findBySchool_IdAndBoardAndClassLevel(school.getId(), board, classLevel)
                : unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);

        for (Unit u : units) {
            if (u.getUnitNumber() == unitNumber || u.getUnitName().equalsIgnoreCase(unitName)) {
                return u;
            }
        }
        Unit newUnit = new Unit(unitName, unitNumber, board, classLevel);
        if (school != null) newUnit.setSchool(school);
        return unitRepository.save(newUnit);
    }

    private Chapter getOrCreateChapter(School school, String board, int classLevel, String unitName, int chNumber, String chName) {
        Chapter ch = (school != null)
                ? chapterRepository.findBySchool_IdAndBoardAndClassLevelAndChapterNumber(school.getId(), board, classLevel, chNumber).orElse(null)
                : chapterRepository.findBySchoolIsNullAndBoardAndClassLevelAndChapterNumber(board, classLevel, chNumber).orElse(null);

        if (ch == null) {
            ch = new Chapter();
            ch.setUnit(unitName);
            ch.setChapterNumber(chNumber);
            ch.setChapterName(chName);
            ch.setUnlocked(chNumber == 1);
            ch.setBoard(board);
            ch.setClassLevel(classLevel);
            if (school != null) ch.setSchool(school);
            ch = chapterRepository.save(ch);
        }

        for (int m = 1; m <= 4; m++) {
            final int currentM = m;
            final Chapter finalCh = ch;
            boolean missionExists = missionRepository.findByChapter_Id(finalCh.getId()).stream()
                    .anyMatch(mis -> mis.getMissionNumber() != null && mis.getMissionNumber() == currentM);

            if (!missionExists) {
                Mission mission = new Mission();
                mission.setMissionNumber(m);
                String gameType = (m == 1 || m == 3) ? "MCQ Quiz" :
                                  (m == 2) ? "Fill in the Blank" : "Scenario Challenge";
                mission.setGameType(gameType);
                mission.setChapter(ch);
                if (school != null) mission.setSchool(school);
                missionRepository.save(mission);
            }
        }
        return ch;
    }

    private void addQuestionIfMissing(School school, String board, int classLevel, String unit, String chapter, int mission,
                                      String questionText, String qType, String optA, String optB, String optC, String optD,
                                      String correctAns, String codeLang) {
        List<Question> existing = (school != null)
                ? questionRepository.findBySchool_IdAndBoardAndClassLevelAndUnitAndChapterAndMission(school.getId(), board, classLevel, unit, chapter, mission)
                : questionRepository.findBySchoolIsNullAndBoardAndClassLevelAndUnitAndChapterAndMission(board, classLevel, unit, chapter, mission);

        boolean alreadyExists = existing.stream().anyMatch(q -> q.getQuestionText().equalsIgnoreCase(questionText.trim()));
        if (alreadyExists || existing.size() >= 5) {
            return;
        }

        Question q = new Question();
        q.setUnit(unit);
        q.setChapter(chapter);
        q.setMission(mission);
        q.setQuestionText(questionText);
        q.setQuestionType(qType);
        q.setOptionA(optA);
        q.setOptionB(optB);
        q.setOptionC(optC);
        q.setOptionD(optD);
        q.setCorrectAnswer(correctAns);
        q.setBoard(board);
        q.setClassLevel(classLevel);
        q.setCodeLanguage(codeLang);
        if (school != null) q.setSchool(school);
        questionRepository.save(q);
    }
`;

console.log("Base Java seeder structure ready");
