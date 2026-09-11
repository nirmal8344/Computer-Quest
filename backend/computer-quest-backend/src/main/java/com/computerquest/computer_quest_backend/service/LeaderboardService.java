package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.dto.LeaderboardEntryDto;
import com.computerquest.computer_quest_backend.dto.LeaderboardResponseDto;
import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import com.computerquest.computer_quest_backend.entity.User;
import com.computerquest.computer_quest_backend.repository.PlayerProgressRepository;
import com.computerquest.computer_quest_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LeaderboardService {

    private final PlayerProgressRepository playerProgressRepository;
    private final UserRepository userRepository;

    public LeaderboardService(
            PlayerProgressRepository playerProgressRepository,
            UserRepository userRepository) {
        this.playerProgressRepository = playerProgressRepository;
        this.userRepository = userRepository;
    }

    public LeaderboardResponseDto getRankings(Long userId, String subject, String board, Integer classLevel, Long schoolId) {
        return getRankings(userId, subject, board, classLevel, schoolId, null);
    }

    public LeaderboardResponseDto getRankings(Long userId, String subject, String board, Integer classLevel, Long schoolId, String studentGroup) {
        User currentUser = userId != null ? userRepository.findById(userId).orElse(null) : null;
        if (currentUser != null) {
            if (board == null) board = currentUser.getBoard();
            if (classLevel == null) classLevel = currentUser.getClassLevel();
            if (studentGroup == null) studentGroup = currentUser.getStudentGroup();
            if (schoolId == null && currentUser.getSchool() != null) {
                schoolId = currentUser.getSchool().getId();
            }
        }

        List<LeaderboardEntryDto> entries = new ArrayList<>();
        boolean isSubjectLeaderboard = subject != null && !subject.trim().isEmpty() && !subject.equalsIgnoreCase("OVERALL");

        final String targetBoard = board;
        final Integer targetClass = classLevel;
        final String targetGroup = (classLevel != null && classLevel >= 11) ? studentGroup : null;

        final Long targetSchoolId = schoolId;

        if (isSubjectLeaderboard) {
            // Subject-wise leaderboard
            String targetSub = subject.trim();
            List<PlayerProgress> progresses = playerProgressRepository.findBySubjectOrderByXpDesc(targetSub);

            // Filter by school, board, classLevel, and studentGroup
            progresses = progresses.stream()
                    .filter(pp -> {
                        User u = pp.getUser();
                        if (u == null) return false;
                        if (targetSchoolId != null && (u.getSchool() == null || !targetSchoolId.equals(u.getSchool().getId()))) {
                            return false;
                        }
                        if (targetBoard != null && u.getBoard() != null && !targetBoard.equalsIgnoreCase(u.getBoard())) {
                            return false;
                        }
                        if (targetClass != null && u.getClassLevel() != null && !targetClass.equals(u.getClassLevel())) {
                            return false;
                        }
                        if (targetClass != null && targetClass >= 11 && targetGroup != null) {
                            return isSameGroup(u.getStudentGroup(), targetGroup);
                        }
                        return true;
                    })
                    .collect(Collectors.toList());

            int rank = 1;
            boolean currentUserIncluded = false;
            for (PlayerProgress pp : progresses) {
                User u = pp.getUser();
                if (u == null) continue;
                if (currentUser != null && u.getId().equals(currentUser.getId())) {
                    currentUserIncluded = true;
                }
                String schoolName = u.getSchool() != null ? u.getSchool().getName() : "RPSIT School";
                entries.add(new LeaderboardEntryDto(
                        rank++,
                        u.getId(),
                        u.getUsername(),
                        u.getBoard(),
                        u.getClassLevel(),
                        schoolName,
                        u.getStudentGroup(),
                        pp.getXp() != null ? pp.getXp() : 0,
                        pp.getCurrentChapter() != null ? pp.getCurrentChapter() : 1,
                        pp.getCurrentMission() != null ? pp.getCurrentMission() : 1,
                        targetSub
                ));
            }

            if (!currentUserIncluded && currentUser != null) {
                String schoolName = currentUser.getSchool() != null ? currentUser.getSchool().getName() : "RPSIT School";
                entries.add(new LeaderboardEntryDto(
                        rank++,
                        currentUser.getId(),
                        currentUser.getUsername(),
                        currentUser.getBoard(),
                        currentUser.getClassLevel(),
                        schoolName,
                        currentUser.getStudentGroup(),
                        0,
                        1,
                        1,
                        targetSub
                ));
            }
        } else {
            // Overall Leaderboard (Total XP aggregated across all subjects per student within same Board+Class (+Group if 11-12))
            List<User> students = userRepository.findAll().stream()
                    .filter(u -> "STUDENT".equalsIgnoreCase(u.getRole()) || u.getRole() == null)
                    .collect(Collectors.toList());

            if (targetSchoolId != null) {
                students = students.stream()
                        .filter(u -> u.getSchool() != null && targetSchoolId.equals(u.getSchool().getId()))
                        .collect(Collectors.toList());
            }

            if (targetBoard != null && targetClass != null) {
                students = students.stream()
                        .filter(u -> (targetBoard.equalsIgnoreCase(u.getBoard()) || u.getBoard() == null) &&
                                (targetClass.equals(u.getClassLevel()) || u.getClassLevel() == null))
                        .collect(Collectors.toList());

                // Class 11 & 12: strictly compare within the same group
                if (targetClass >= 11 && targetGroup != null) {
                    students = students.stream()
                            .filter(u -> isSameGroup(u.getStudentGroup(), targetGroup))
                            .collect(Collectors.toList());
                }
            }

            // Calculate total XP per user
            Map<Long, Integer> userTotalXpMap = new HashMap<>();
            Map<Long, PlayerProgress> userLatestProgressMap = new HashMap<>();

            List<PlayerProgress> allProgress = playerProgressRepository.findAll();
            for (PlayerProgress pp : allProgress) {
                if (pp.getUser() == null) continue;
                Long uId = pp.getUser().getId();
                int xp = pp.getXp() != null ? pp.getXp() : 0;
                userTotalXpMap.put(uId, userTotalXpMap.getOrDefault(uId, 0) + xp);
                userLatestProgressMap.put(uId, pp);
            }

            // Build rows
            List<LeaderboardEntryDto> rawList = new ArrayList<>();
            for (User u : students) {
                int totalXp = userTotalXpMap.getOrDefault(u.getId(), 0);
                PlayerProgress lp = userLatestProgressMap.get(u.getId());
                String schoolName = u.getSchool() != null ? u.getSchool().getName() : "RPSIT School";

                rawList.add(new LeaderboardEntryDto(
                        0,
                        u.getId(),
                        u.getUsername(),
                        u.getBoard(),
                        u.getClassLevel(),
                        schoolName,
                        u.getStudentGroup(),
                        totalXp,
                        lp != null && lp.getCurrentChapter() != null ? lp.getCurrentChapter() : 1,
                        lp != null && lp.getCurrentMission() != null ? lp.getCurrentMission() : 1,
                        "OVERALL"
                ));
            }

            // Sort by XP descending
            rawList.sort((a, b) -> Integer.compare(b.getXp(), a.getXp()));

            int rank = 1;
            for (LeaderboardEntryDto item : rawList) {
                item.setRank(rank++);
                entries.add(item);
            }
        }

        // Calculate current user rank details
        Integer currentRank = null;
        Integer currentXp = 0;
        Integer xpToNextRank = 0;

        if (currentUser != null) {
            for (int i = 0; i < entries.size(); i++) {
                LeaderboardEntryDto entry = entries.get(i);
                if (entry.getUserId().equals(currentUser.getId())) {
                    currentRank = entry.getRank();
                    currentXp = entry.getXp();
                    if (i > 0) {
                        LeaderboardEntryDto above = entries.get(i - 1);
                        xpToNextRank = Math.max(10, (above.getXp() - currentXp) + 10);
                    } else {
                        xpToNextRank = 0; // Already #1!
                    }
                    break;
                }
            }
        }

        return new LeaderboardResponseDto(
                entries,
                currentRank != null ? currentRank : 1,
                currentXp,
                xpToNextRank,
                isSubjectLeaderboard ? subject : "OVERALL",
                targetGroup
        );
    }

    private boolean isSameGroup(String g1, String g2) {
        if (g1 == null && g2 == null) return true;
        if (g1 == null || g2 == null) return false;
        String s1 = g1.trim().toUpperCase();
        String s2 = g2.trim().toUpperCase();
        if (s1.equals(s2)) return true;

        if ((s1.contains("BIO") || s1.contains("GROUP 1")) && (s2.contains("BIO") || s2.contains("GROUP 1"))) return true;
        if ((s1.contains("COMPUTER") || s1.contains("GROUP 2")) && (s2.contains("COMPUTER") || s2.contains("GROUP 2"))) return true;
        if ((s1.contains("PURE") || s1.contains("GROUP 3")) && (s2.contains("PURE") || s2.contains("GROUP 3"))) return true;
        if ((s1.contains("HISTORY") || s1.contains("GROUP 7") || s1.contains("ACC_HISTORY")) && (s2.contains("HISTORY") || s2.contains("GROUP 7") || s2.contains("ACC_HISTORY"))) return true;
        if ((s1.contains("APPLICATION") || s1.contains("GROUP 5") || s1.contains("COMMERCE_CA")) && (s2.contains("APPLICATION") || s2.contains("GROUP 5") || s2.contains("COMMERCE_CA"))) return true;
        if ((s1.contains("BUSINESS") || s1.contains("GROUP 6") || s1.contains("COMMERCE_BM")) && (s2.contains("BUSINESS") || s2.contains("GROUP 6") || s2.contains("COMMERCE_BM"))) return true;
        if (s1.contains("COMMERCE") && s2.contains("COMMERCE") && !s1.contains("APPLICATION") && !s2.contains("APPLICATION") && !s1.contains("BUSINESS") && !s2.contains("BUSINESS") && !s1.contains("HISTORY") && !s2.contains("HISTORY")) return true;

        return false;
    }

    // Backwards compatible method
    public List<PlayerProgress> getLeaderboard(Long userId, Long schoolId) {
        if (userId != null) {
            User u = userRepository.findById(userId).orElse(null);
            if (u != null && u.getSchool() != null) {
                return playerProgressRepository.findByUser_School_IdOrderByXpDesc(u.getSchool().getId());
            }
        }
        if (schoolId != null) {
            return playerProgressRepository.findByUser_School_IdOrderByXpDesc(schoolId);
        }
        return playerProgressRepository.findAllByOrderByXpDesc();
    }
}