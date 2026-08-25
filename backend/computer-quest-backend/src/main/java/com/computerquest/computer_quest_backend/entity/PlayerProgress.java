package com.computerquest.computer_quest_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_progress")
public class PlayerProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer currentChapter;
    private Integer currentMission;
    private Integer lives;
    private Integer xp;

    private Integer answeredQuestions;
    private Integer pendingXp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PlayerProgress() {
    }

    public Long getId() {
        return id;
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
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(Integer answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public Integer getPendingXp() {
        return pendingXp;
    }

    public void setPendingXp(Integer pendingXp) {
        this.pendingXp = pendingXp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}