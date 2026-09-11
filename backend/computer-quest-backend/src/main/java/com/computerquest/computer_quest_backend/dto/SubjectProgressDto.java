package com.computerquest.computer_quest_backend.dto;

public class SubjectProgressDto {

    private String subjectName;
    private String subjectCode;
    private String icon;
    private String color;
    private Integer currentChapter;
    private Integer currentMission;
    private Integer xp;
    private Integer lives;

    public SubjectProgressDto() {
    }

    public SubjectProgressDto(String subjectName, String subjectCode, String icon, String color, Integer currentChapter, Integer currentMission, Integer xp, Integer lives) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.icon = icon;
        this.color = color;
        this.currentChapter = currentChapter;
        this.currentMission = currentMission;
        this.xp = xp;
        this.lives = lives;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }
}
