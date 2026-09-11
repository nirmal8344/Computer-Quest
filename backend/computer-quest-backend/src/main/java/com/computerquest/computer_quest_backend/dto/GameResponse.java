package com.computerquest.computer_quest_backend.dto;

import com.computerquest.computer_quest_backend.entity.School;
import java.util.List;

public class GameResponse {

    private Long userId;
    private String username;
    private Integer currentChapter;
    private Integer currentMission;
    private Integer lives;
    private Integer xp; // Total XP across all subjects
    private Integer totalXp;
    private Integer streakDays;
    private String currentSubject;
    private String board;
    private Integer classLevel;
    private String studentGroup;
    private School school;
    private List<SubjectProgressDto> subjects;

    public GameResponse() {
    }

    public GameResponse(
            Long userId,
            String username,
            Integer currentChapter,
            Integer currentMission,
            Integer lives,
            Integer xp,
            String board,
            Integer classLevel,
            School school) {

        this.userId = userId;
        this.username = username;
        this.currentChapter = currentChapter;
        this.currentMission = currentMission;
        this.lives = lives;
        this.xp = xp;
        this.totalXp = xp;
        this.streakDays = 1;
        this.board = board;
        this.classLevel = classLevel;
        this.school = school;
    }

    public GameResponse(
            Long userId,
            String username,
            Integer currentChapter,
            Integer currentMission,
            Integer lives,
            Integer xp,
            Integer totalXp,
            Integer streakDays,
            String currentSubject,
            String board,
            Integer classLevel,
            String studentGroup,
            School school,
            List<SubjectProgressDto> subjects) {

        this.userId = userId;
        this.username = username;
        this.currentChapter = currentChapter;
        this.currentMission = currentMission;
        this.lives = lives;
        this.xp = xp;
        this.totalXp = totalXp;
        this.streakDays = streakDays;
        this.currentSubject = currentSubject;
        this.board = board;
        this.classLevel = classLevel;
        this.studentGroup = studentGroup;
        this.school = school;
        this.subjects = subjects;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCurrentChapter() {
        return currentChapter;
    }

    public void setCurrentChapter(Integer currentChapter) {
        this.currentChapter = currentChapter;
    }

    public Integer getCurrentMission() {
        return currentMission;
    }

    public void setCurrentMission(Integer currentMission) {
        this.currentMission = currentMission;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getXp() {
        return totalXp != null ? totalXp : xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getTotalXp() {
        return totalXp != null ? totalXp : xp;
    }

    public void setTotalXp(Integer totalXp) {
        this.totalXp = totalXp;
    }

    public Integer getStreakDays() {
        return streakDays != null ? streakDays : 1;
    }

    public void setStreakDays(Integer streakDays) {
        this.streakDays = streakDays;
    }

    public String getCurrentSubject() {
        return currentSubject;
    }

    public void setCurrentSubject(String currentSubject) {
        this.currentSubject = currentSubject;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public Integer getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<SubjectProgressDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectProgressDto> subjects) {
        this.subjects = subjects;
    }
}