package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final AdminRepository adminRepository;
    private final MissionRepository missionRepository;

    public ChapterService(
            ChapterRepository chapterRepository,
            UserRepository userRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository,
            MissionRepository missionRepository) {
        this.chapterRepository = chapterRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
        this.missionRepository = missionRepository;
    }

    public Chapter saveChapter(Chapter chapter) {
        resolveSchool(chapter);
        Chapter saved = chapterRepository.save(chapter);
        ensureDefaultMissions(saved);
        return saved;
    }

    private void ensureDefaultMissions(Chapter chapter) {
        List<Mission> existing = missionRepository.findByChapter_Id(chapter.getId());
        if (existing == null || existing.isEmpty()) {
            String[] defaultTypes = new String[]{"MCQ Quiz", "Fill in the Blank", "Scenario Challenge", "MCQ Quiz"};
            for (int m = 1; m <= 4; m++) {
                Mission mission = new Mission();
                mission.setMissionNumber(m);
                mission.setGameType(defaultTypes[m - 1]);
                mission.setChapter(chapter);
                if (chapter.getSchool() != null) {
                    mission.setSchool(chapter.getSchool());
                }
                missionRepository.save(mission);
            }
        }
    }

    private void resolveSchool(Chapter chapter) {
        if (chapter.getSchool() != null && chapter.getSchool().getId() != null) {
            chapter.setSchool(schoolRepository.findById(chapter.getSchool().getId()).orElse(null));
        } else if (chapter.getSchoolId() != null) {
            chapter.setSchool(schoolRepository.findById(chapter.getSchoolId()).orElse(null));
        } else if (chapter.getSchoolName() != null && !chapter.getSchoolName().trim().isEmpty()) {
            String name = chapter.getSchoolName().trim();
            chapter.setSchool(schoolRepository.findByName(name).orElseGet(() -> schoolRepository.save(new School(name))));
        } else if (chapter.getAdminId() != null) {
            Admin admin = adminRepository.findById(chapter.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                chapter.setSchool(admin.getSchool());
            }
        }
    }

    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    public List<Chapter> getChapters(String board, Integer classLevel, Long userId, Long adminId, Long schoolId) {
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                return chapterRepository.findBySchool_Id(admin.getSchool().getId());
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

        if (schoolId != null) {
            if (board != null && classLevel != null) {
                List<Chapter> schoolChapters = chapterRepository.findBySchool_IdAndBoardAndClassLevel(schoolId, board, classLevel);
                if (!schoolChapters.isEmpty()) {
                    return schoolChapters;
                }
            } else {
                List<Chapter> schoolChapters = chapterRepository.findBySchool_Id(schoolId);
                if (!schoolChapters.isEmpty()) {
                    return schoolChapters;
                }
            }
            if (board != null && classLevel != null) {
                return chapterRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
            }
            return chapterRepository.findBySchoolIsNull();
        }

        if (board != null && classLevel != null) {
            List<Chapter> filtered = chapterRepository.findBySchoolIsNullAndBoardAndClassLevel(board, classLevel);
            if (!filtered.isEmpty()) {
                return filtered;
            }
        }

        return chapterRepository.findAll();
    }

    public Chapter updateChapter(Long id, Chapter chapter) {
        Chapter existingChapter = chapterRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Chapter not found"));

        chapter.setId(existingChapter.getId());
        resolveSchool(chapter);
        return chapterRepository.save(chapter);
    }

    public void deleteChapter(Long id) {
        Chapter existing = chapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chapter not found"));

        // Delete child missions
        List<Mission> missions = missionRepository.findByChapter_Id(existing.getId());
        for (Mission m : missions) {
            missionRepository.delete(m);
        }

        chapterRepository.deleteById(id);
    }
}