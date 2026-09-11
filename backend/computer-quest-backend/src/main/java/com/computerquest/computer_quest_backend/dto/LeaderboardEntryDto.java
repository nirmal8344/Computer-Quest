package com.computerquest.computer_quest_backend.dto;

public class LeaderboardEntryDto {

    private Integer rank;
    private Long userId;
    private String username;
    private String board;
    private Integer classLevel;
    private String schoolName;
    private String studentGroup;
    private Integer xp;
    private Integer currentChapter;
    private Integer currentMission;
    private String subject;

    public LeaderboardEntryDto() {
    }

    public LeaderboardEntryDto(Integer rank, Long userId, String username, String board, Integer classLevel, String schoolName, Integer xp, Integer currentChapter, Integer currentMission, String subject) {
        this(rank, userId, username, board, classLevel, schoolName, null, xp, currentChapter, currentMission, subject);
    }

    public LeaderboardEntryDto(Integer rank, Long userId, String username, String board, Integer classLevel, String schoolName, String studentGroup, Integer xp, Integer currentChapter, Integer currentMission, String subject) {
        this.rank = rank;
        this.userId = userId;
        this.username = username;
        this.board = board;
        this.classLevel = classLevel;
        this.schoolName = schoolName;
        this.studentGroup = studentGroup;
        this.xp = xp;
        this.currentChapter = currentChapter;
        this.currentMission = currentMission;
        this.subject = subject;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
