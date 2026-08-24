package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.Admin;
import com.computerquest.computer_quest_backend.repository.AdminRepository;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.UnitRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminDashboardService {

    private final UserRepository userRepository;
    private final UnitRepository unitRepository;
    private final ChapterRepository chapterRepository;
    private final MissionRepository missionRepository;
    private final QuestionRepository questionRepository;
    private final AdminRepository adminRepository;

    public AdminDashboardService(
            UserRepository userRepository,
            UnitRepository unitRepository,
            ChapterRepository chapterRepository,
            MissionRepository missionRepository,
            QuestionRepository questionRepository,
            AdminRepository adminRepository) {

        this.userRepository = userRepository;
        this.unitRepository = unitRepository;
        this.chapterRepository = chapterRepository;
        this.missionRepository = missionRepository;
        this.questionRepository = questionRepository;
        this.adminRepository = adminRepository;
    }

    public Map<String, Long> getDashboard() {
        return getDashboard(null);
    }

    public Map<String, Long> getDashboard(Long adminId) {

        Map<String, Long> dashboard = new HashMap<>();

        long userCount = 0;
        long unitCount = 0;
        long chapterCount = 0;
        long missionCount = 0;
        long questionCount = 0;

        if (adminId != null) {
            Admin admin = adminRepository.findById(adminId).orElse(null);
            if (admin != null && admin.getSchool() != null) {
                Long schoolId = admin.getSchool().getId();
                userCount = userRepository.countBySchoolId(schoolId);
                unitCount = unitRepository.findBySchool_Id(schoolId).size();
                chapterCount = chapterRepository.findBySchool_Id(schoolId).size();
                missionCount = missionRepository.findBySchool_Id(schoolId).size();
                questionCount = questionRepository.findBySchool_Id(schoolId).size();
            } else {
                userCount = userRepository.count();
                unitCount = unitRepository.count();
                chapterCount = chapterRepository.count();
                missionCount = missionRepository.count();
                questionCount = questionRepository.count();
            }
        } else {
            userCount = userRepository.count();
            unitCount = unitRepository.count();
            chapterCount = chapterRepository.count();
            missionCount = missionRepository.count();
            questionCount = questionRepository.count();
        }

        dashboard.put("totalUsers", userCount);
        dashboard.put("totalUnits", unitCount);
        dashboard.put("totalChapters", chapterCount);
        dashboard.put("totalMissions", missionCount);
        dashboard.put("totalQuestions", questionCount);

        return dashboard;
    }
}