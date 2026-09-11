package com.computerquest.computer_quest_backend.dto;

import java.util.List;

public class LeaderboardResponseDto {

    private List<LeaderboardEntryDto> entries;
    private Integer currentUserRank;
    private Integer currentUserXp;
    private Integer xpToNextRank;
    private String category; // "OVERALL" or subject name
    private String studentGroup;

    public LeaderboardResponseDto() {
    }

    public LeaderboardResponseDto(List<LeaderboardEntryDto> entries, Integer currentUserRank, Integer currentUserXp, Integer xpToNextRank, String category) {
        this(entries, currentUserRank, currentUserXp, xpToNextRank, category, null);
    }

    public LeaderboardResponseDto(List<LeaderboardEntryDto> entries, Integer currentUserRank, Integer currentUserXp, Integer xpToNextRank, String category, String studentGroup) {
        this.entries = entries;
        this.currentUserRank = currentUserRank;
        this.currentUserXp = currentUserXp;
        this.xpToNextRank = xpToNextRank;
        this.category = category;
        this.studentGroup = studentGroup;
    }

    public List<LeaderboardEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<LeaderboardEntryDto> entries) {
        this.entries = entries;
    }

    public List<LeaderboardEntryDto> getRankings() {
        return entries;
    }

    public void setRankings(List<LeaderboardEntryDto> rankings) {
        this.entries = rankings;
    }

    public Integer getCurrentUserRank() {
        return currentUserRank;
    }

    public void setCurrentUserRank(Integer currentUserRank) {
        this.currentUserRank = currentUserRank;
    }

    public Integer getCurrentUserXp() {
        return currentUserXp;
    }

    public void setCurrentUserXp(Integer currentUserXp) {
        this.currentUserXp = currentUserXp;
    }

    public Integer getXpToNextRank() {
        return xpToNextRank;
    }

    public void setXpToNextRank(Integer xpToNextRank) {
        this.xpToNextRank = xpToNextRank;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }
}
