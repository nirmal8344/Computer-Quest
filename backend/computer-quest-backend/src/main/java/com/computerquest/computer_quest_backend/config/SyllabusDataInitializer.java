package com.computerquest.computer_quest_backend.config;

import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class SyllabusDataInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final QuestionRepository questionRepository;
    private final LearnQuestCurriculumSeeder learnQuestCurriculumSeeder;

    public SyllabusDataInitializer(
            AdminRepository adminRepository,
            QuestionRepository questionRepository,
            LearnQuestCurriculumSeeder learnQuestCurriculumSeeder) {
        this.adminRepository = adminRepository;
        this.questionRepository = questionRepository;
        this.learnQuestCurriculumSeeder = learnQuestCurriculumSeeder;
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
            List<com.computerquest.computer_quest_backend.entity.Question> seeded = questionRepository.findByQuestionTextContaining("What is the core concept here?");
            if (!seeded.isEmpty()) {
                questionRepository.deleteAll(seeded);
            }
        }

        // Seed comprehensive multi-subject curricula for Classes 4 to 12 (CBSE & State Board)
        learnQuestCurriculumSeeder.seedAllCurricula();
    }
}
