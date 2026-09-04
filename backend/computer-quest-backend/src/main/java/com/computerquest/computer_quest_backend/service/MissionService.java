package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final AdminRepository adminRepository;

    public MissionService(
            MissionRepository missionRepository,
            UserRepository userRepository,
            SchoolRepository schoolRepository,
            AdminRepository adminRepository) {
        this.missionRepository = missionRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.adminRepository = adminRepository;
    }

    public Mission saveMission(Mission mission) {
        resolveSchool(mission);
        return missionRepository.save(mission);
    }

    private void resolveSchool(Mission mission) {
        if (mission.getSchool() != null && mission.getSchool().getId() != null) {
            mission.setSchool(schoolRepository.findById(mission.getSchool().getId()).orElse(null));
        } else if (mission.getSchoolId() != null) {
            mission.setSchool(schoolRepository.findById(mission.getSchoolId()).orElse(null));
        } else if (mission.getSchoolName() != null && !mission.getSchoolName().trim().isEmpty()) {
            String name = mission.getSchoolName().trim();
            mission.setSchool(schoolRepository.findByName(name).orElseGet(() -> schoolRepository.save(new School(name))));
        } else if (mission.getChapter() != null && mission.getChapter().getSchool() != null) {
            mission.setSchool(mission.getChapter().getSchool());
        } else if (mission.getAdminId() != null) {
            Admin admin = adminRepository.findById(mission.getAdminId()).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                mission.setSchool(admin.getSchool());
            }
        }
    }

    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    public List<Mission> getMissions(String board, Integer classLevel, Long userId, Long adminId, Long schoolId) {
        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                return missionRepository.findBySchool_Id(admin.getSchool().getId());
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

        List<Mission> rawResult = new ArrayList<>();
        if (schoolId != null) {
            if (board != null && classLevel != null) {
                List<Mission> schoolMissions = missionRepository.findBySchool_IdAndChapterBoardAndChapterClassLevel(schoolId, board, classLevel);
                if (!schoolMissions.isEmpty()) {
                    rawResult = schoolMissions;
                }
            } else {
                List<Mission> schoolMissions = missionRepository.findBySchool_Id(schoolId);
                if (!schoolMissions.isEmpty()) {
                    rawResult = schoolMissions;
                }
            }
            if (rawResult.isEmpty()) {
                if (board != null && classLevel != null) {
                    rawResult = missionRepository.findBySchoolIsNullAndChapterBoardAndChapterClassLevel(board, classLevel);
                } else {
                    rawResult = missionRepository.findBySchoolIsNull();
                }
            }
        } else if (board != null && classLevel != null) {
            List<Mission> filtered = missionRepository.findBySchoolIsNullAndChapterBoardAndChapterClassLevel(board, classLevel);
            if (!filtered.isEmpty()) {
                rawResult = filtered;
            }
        }

        if (rawResult.isEmpty()) {
            rawResult = missionRepository.findAll();
        }

        // Deduplicate and sort strictly in ascending order by missionNumber (1, 2, 3, 4)
        rawResult.sort(java.util.Comparator.comparing(m -> m.getMissionNumber() != null ? m.getMissionNumber() : 0));
        return rawResult;
    }

    public Mission updateMission(Long id, Mission mission) {

        Mission existingMission = missionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Mission not found"));

        mission.setId(existingMission.getId());

        return missionRepository.save(mission);
    }

    public void deleteMission(Long id) {

        if (!missionRepository.existsById(id)) {
            throw new RuntimeException("Mission not found");
        }

        missionRepository.deleteById(id);
    }
}