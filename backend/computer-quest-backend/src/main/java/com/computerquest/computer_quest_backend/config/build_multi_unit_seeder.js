const fs = require('fs');
const path = require('path');

const datasets = [
  ...require('./curriculum_cbse_full.js'),
  ...require('./data_cbse_5_multi.js'),
  ...require('./data_cbse_6_multi.js'),
  ...require('./data_cbse_7_multi.js'),
  ...require('./data_cbse_8_multi.js'),
  ...require('./data_cbse_9_multi.js'),
  ...require('./data_cbse_10_multi.js'),
  ...require('./data_state_4_6_multi.js'),
  ...require('./data_state_7_10_multi.js')
];

function escapeJavaString(str) {
  if (str === null || str === undefined) return '""';
  return JSON.stringify(str);
}

let out = `package com.computerquest.computer_quest_backend.config;

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

        // 2. Seed All Multi-Unit Syllabus Modules for Classes 4 to 10
`;

datasets.forEach(d => {
  const methodName = `seed${d.board === 'CBSE' ? 'Cbse' : 'StateBoard'}Class${d.classLevel}`;
  out += `        ${methodName}(demoSchool);\n`;
});

out += `    }

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

    private void cleanupOrphans(School school, String board, int classLevel, int maxUnitNum, int maxChNum) {
        if (school == null) return;
        List<Unit> units = unitRepository.findBySchool_IdAndBoardAndClassLevel(school.getId(), board, classLevel);
        for (Unit u : units) {
            if (u.getUnitNumber() > maxUnitNum) {
                unitRepository.delete(u);
            }
        }
        List<Chapter> chapters = chapterRepository.findBySchool_IdAndBoardAndClassLevel(school.getId(), board, classLevel);
        for (Chapter ch : chapters) {
            if (ch.getChapterNumber() != null && ch.getChapterNumber() > maxChNum) {
                List<Mission> missions = missionRepository.findByChapter_Id(ch.getId());
                for (Mission m : missions) {
                    missionRepository.delete(m);
                }
                chapterRepository.delete(ch);
            }
        }
    }

    private Unit getOrCreateUnit(School school, String board, int classLevel, int unitNumber, String unitName) {
        List<Unit> units = (school != null)
                ? unitRepository.findBySchool_IdAndBoardAndClassLevel(school.getId(), board, classLevel)
                : unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);

        for (Unit u : units) {
            if (u.getUnitNumber() == unitNumber) {
                if (!u.getUnitName().equalsIgnoreCase(unitName)) {
                    u.setUnitName(unitName);
                    return unitRepository.save(u);
                }
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
        } else {
            boolean changed = false;
            if (ch.getUnit() == null || !ch.getUnit().equalsIgnoreCase(unitName)) {
                ch.setUnit(unitName);
                changed = true;
            }
            if (ch.getChapterName() == null || !ch.getChapterName().equalsIgnoreCase(chName)) {
                ch.setChapterName(chName);
                changed = true;
            }
            if (changed) {
                ch = chapterRepository.save(ch);
            }
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

datasets.forEach(d => {
  const methodName = `seed${d.board === 'CBSE' ? 'Cbse' : 'StateBoard'}Class${d.classLevel}`;
  const maxUnitNum = d.units.length;
  let maxChNum = 0;
  d.units.forEach(u => {
    u.chapters.forEach(ch => {
      if (ch.num > maxChNum) maxChNum = ch.num;
    });
  });

  out += `\n    // ==========================================\n`;
  out += `    // ${d.board} CLASS ${d.classLevel}\n`;
  out += `    // ==========================================\n`;
  out += `    private void ${methodName}(School school) {\n`;
  out += `        String board = "${d.board}";\n`;
  out += `        int classLevel = ${d.classLevel};\n`;
  out += `        cleanupOrphans(school, board, classLevel, ${maxUnitNum}, ${maxChNum});\n\n`;

  d.units.forEach(u => {
    out += `        // --- ${u.unitName} ---\n`;
    out += `        getOrCreateUnit(school, board, classLevel, ${u.unitNumber}, ${escapeJavaString(u.unitName)});\n`;

    u.chapters.forEach(ch => {
      out += `        // Chapter ${ch.num}: ${ch.name}\n`;
      out += `        getOrCreateChapter(school, board, classLevel, ${escapeJavaString(u.unitName)}, ${ch.num}, ${escapeJavaString(ch.name)});\n`;

      ch.missions.forEach(m => {
        m.q.forEach(qItem => {
          const [qText, qType, optA, optB, optC, optD, correctAns, codeLang] = qItem;
          out += `        addQuestionIfMissing(school, board, classLevel, ${escapeJavaString(u.unitName)}, ${escapeJavaString(ch.name)}, ${m.mNum}, ${escapeJavaString(qText)}, ${escapeJavaString(qType)}, ${escapeJavaString(optA)}, ${escapeJavaString(optB)}, ${escapeJavaString(optC)}, ${escapeJavaString(optD)}, ${escapeJavaString(correctAns)}, ${codeLang ? escapeJavaString(codeLang) : 'null'});\n`;
        });
      });
      out += `\n`;
    });
  });

  out += `    }\n`;
});

out += `}\n`;

const targetFile = path.join(__dirname, 'Class4To10SyllabusSeeder.java');
fs.writeFileSync(targetFile, out, 'utf8');
console.log('Successfully generated Class4To10SyllabusSeeder.java with automated orphan cleanup!');
