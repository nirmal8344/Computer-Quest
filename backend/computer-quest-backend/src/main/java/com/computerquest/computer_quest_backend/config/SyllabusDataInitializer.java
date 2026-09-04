package com.computerquest.computer_quest_backend.config;

import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.UnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SyllabusDataInitializer implements CommandLineRunner {

    private final UnitRepository unitRepository;
    private final ChapterRepository chapterRepository;
    private final MissionRepository missionRepository;
    private final QuestionRepository questionRepository;
    private final com.computerquest.computer_quest_backend.repository.AdminRepository adminRepository;
    private final StateBoardSyllabusSeeder stateBoardSyllabusSeeder;
    private final Class4To10SyllabusSeeder class4To10SyllabusSeeder;

    public SyllabusDataInitializer(
            UnitRepository unitRepository,
            ChapterRepository chapterRepository,
            MissionRepository missionRepository,
            QuestionRepository questionRepository,
            com.computerquest.computer_quest_backend.repository.AdminRepository adminRepository,
            StateBoardSyllabusSeeder stateBoardSyllabusSeeder,
            Class4To10SyllabusSeeder class4To10SyllabusSeeder) {
        this.unitRepository = unitRepository;
        this.chapterRepository = chapterRepository;
        this.missionRepository = missionRepository;
        this.questionRepository = questionRepository;
        this.adminRepository = adminRepository;
        this.stateBoardSyllabusSeeder = stateBoardSyllabusSeeder;
        this.class4To10SyllabusSeeder = class4To10SyllabusSeeder;
    }

    @Override
    public void run(String... args) {
        // Clean up duplicate admin records in DB only if duplicate count > 1
        if (adminRepository.count() > 1) {
            List<com.computerquest.computer_quest_backend.entity.Admin> allAdmins = adminRepository.findAll();
            java.util.Set<String> seenUsernames = new java.util.HashSet<>();
            java.util.List<com.computerquest.computer_quest_backend.entity.Admin> duplicatesToDelete = new java.util.ArrayList<>();
            for (com.computerquest.computer_quest_backend.entity.Admin a : allAdmins) {
                if (a.getUsername() != null) {
                    if (seenUsernames.contains(a.getUsername())) {
                        duplicatesToDelete.add(a);
                    } else {
                        seenUsernames.add(a.getUsername());
                    }
                }
            }
            if (!duplicatesToDelete.isEmpty()) {
                adminRepository.deleteAll(duplicatesToDelete);
            }
        }

        // Clean up pre-seeded dummy questions only if dummy questions actually exist
        if (questionRepository.existsByQuestionTextContaining("What is the core concept here?")) {
            List<Question> seeded = questionRepository.findByQuestionTextContaining("What is the core concept here?");
            if (!seeded.isEmpty()) {
                questionRepository.deleteAll(seeded);
            }
        }

        // Fast check before seeding CBSE syllabus
        if (!unitRepository.existsBySchoolIsNullAndBoardAndClassLevel("CBSE", 11)) {
            seedSyllabus("CBSE", 11, "CBSE Class 11 CS", new String[]{
                    "CBSE 11 - Computer Systems & Architecture",
                    "CBSE 11 - Computational Thinking & Python",
                    "CBSE 11 - Data Representation & Logic Gates",
                    "CBSE 11 - Cyber Safety & Ethics"
            });
        }

        if (!unitRepository.existsBySchoolIsNullAndBoardAndClassLevel("CBSE", 12)) {
            seedSyllabus("CBSE", 12, "CBSE Class 12 CS", new String[]{
                    "CBSE 12 - Advanced Python & Data Structures",
                    "CBSE 12 - Computer Networks & Protocols",
                    "CBSE 12 - Database Concepts & SQL",
                    "CBSE 12 - Interface Python with SQL"
            });
        }

        // Seed Computer Quest Demo School State Board Class 11 and Class 12 Syllabus
        stateBoardSyllabusSeeder.seedDemoSchoolSyllabus();

        // Seed Computer Quest Demo School Classes 4 to 10 (CBSE & State Board)
        class4To10SyllabusSeeder.seedClasses4To10();
    }

    private void seedSyllabus(String board, int classLevel, String unitName, String[] chapterNames) {
        List<Unit> existingUnits = unitRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
        Unit unitEntity;
        if (existingUnits.isEmpty()) {
            unitEntity = unitRepository.save(new Unit(unitName, 1, board, classLevel));
        } else {
            unitEntity = existingUnits.get(0);
        }

        for (int chIndex = 0; chIndex < chapterNames.length; chIndex++) {
            int chNum = chIndex + 1;
            String chName = chapterNames[chIndex];

            Chapter chapterEntity = chapterRepository
                    .findBySchoolIsNullAndBoardAndClassLevelAndChapterNumber(board, classLevel, chNum)
                    .orElse(null);

            if (chapterEntity == null) {
                chapterEntity = new Chapter();
                chapterEntity.setUnit(unitName);
                chapterEntity.setChapterNumber(chNum);
                chapterEntity.setChapterName(chName);
                chapterEntity.setUnlocked(chNum == 1);
                chapterEntity.setBoard(board);
                chapterEntity.setClassLevel(classLevel);
                chapterEntity = chapterRepository.save(chapterEntity);
            }

            for (int mNum = 1; mNum <= 4; mNum++) {
                final int currentMNum = mNum;
                final Chapter finalChapterEntity = chapterEntity;
                List<Mission> existingMissions = missionRepository
                        .findBySchoolIsNullAndChapterBoardAndChapterClassLevel(board, classLevel)
                        .stream()
                        .filter(m -> m.getChapter() != null && m.getChapter().getId().equals(finalChapterEntity.getId()) && m.getMissionNumber().equals(currentMNum))
                        .toList();

                if (existingMissions.isEmpty()) {
                    Mission missionEntity = new Mission();
                    missionEntity.setMissionNumber(mNum);
                    String gameType = (mNum == 1 || mNum == 3) ? "MCQ Quiz" :
                                      (mNum == 2) ? "Fill in the Blank" : "Scenario Challenge";
                    missionEntity.setGameType(gameType);
                    missionEntity.setChapter(chapterEntity);
                    missionRepository.save(missionEntity);
                }
            }
        }
    }
}
