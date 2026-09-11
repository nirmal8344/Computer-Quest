package com.computerquest.computer_quest_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private String subjectCode;
    private String icon;
    private String color;

    private String board;
    private Integer classLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    private School school;

    @Transient
    private Long schoolId;

    @Transient
    private String schoolName;

    @Transient
    private Long adminId;

    public Subject() {
    }

    public Subject(String subjectName, String subjectCode, String icon, String color, String board, Integer classLevel) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.icon = icon;
        this.color = color;
        this.board = board;
        this.classLevel = classLevel;
    }

    public Subject(String subjectName, String subjectCode, String icon, String color, String board, Integer classLevel, School school) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.icon = icon;
        this.color = color;
        this.board = board;
        this.classLevel = classLevel;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
