package com.computerquest.computer_quest_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_progress", indexes = {
    @Index(name = "idx_player_progress_user_subject", columnList = "user_id, subject")
})
public class PlayerProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
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

    public PlayerProgress(User user, String subject) {
        this.user = user;
        this.subject = subject;
        this.currentChapter = 1;
        this.currentMission = 1;
        this.lives = 3;
        this.xp = 0;
        this.answeredQuestions = 0;
        this.pendingXp = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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