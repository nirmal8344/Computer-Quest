package com.computerquest.computer_quest_backend.dto;

public class AnswerResponse {

    private String result;
    private Integer lives;
    private Integer xp;

    public AnswerResponse(String result, Integer lives, Integer xp) {
        this.result = result;
        this.lives = lives;
        this.xp = xp;
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
}