package com.computerquest.computer_quest_backend.dto;

import com.computerquest.computer_quest_backend.entity.School;

public class GameResponse {

    private Long userId;
    private String username;
    private Integer currentChapter;
    private Integer currentMission;
    private Integer lives;
    private Integer xp;
    private String board;
    private Integer classLevel;
    private School school;

    public GameResponse() {
    }

    public GameResponse(
            Long userId,
            String username,
            Integer currentChapter,
            Integer currentMission,
            Integer lives,
            Integer xp) {

        this.userId = userId;
        this.username = username;
        this.currentChapter = currentChapter;
        this.currentMission = currentMission;
        this.lives = lives;
        this.xp = xp;
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
        this.board = board;
        this.classLevel = classLevel;
        this.school = school;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getCurrentChapter() {
        return currentChapter;
    }

    public Integer getCurrentMission() {
        return currentMission;
    }

    public Integer getLives() {
        return lives;
    }

    public Integer getXp() {
        return xp;
    }

    public String getBoard() {
        return board;
    }

    public Integer getClassLevel() {
        return classLevel;
    }

    public School getSchool() {
        return school;
    }
}