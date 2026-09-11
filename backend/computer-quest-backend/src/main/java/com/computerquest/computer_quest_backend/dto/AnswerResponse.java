package com.computerquest.computer_quest_backend.dto;

public class AnswerResponse {

    private String result;
    private Integer lives;
    private Integer xp;
    private Integer totalXp;
    private Integer streakDays;

    public AnswerResponse() {
    }

    public AnswerResponse(String result, Integer lives, Integer xp) {
        this.result = result;
        this.lives = lives;
        this.xp = xp;
        this.totalXp = xp;
    }

    public AnswerResponse(String result, Integer lives, Integer xp, Integer totalXp, Integer streakDays) {
        this.result = result;
        this.lives = lives;
        this.xp = xp;
        this.totalXp = totalXp;
        this.streakDays = streakDays;
    }

    public String getResult() {
        return result;
    }

    public Integer getLives() {
        return lives;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getTotalXp() {
        return totalXp != null ? totalXp : xp;
    }

    public Integer getStreakDays() {
        return streakDays != null ? streakDays : 1;
    }
}