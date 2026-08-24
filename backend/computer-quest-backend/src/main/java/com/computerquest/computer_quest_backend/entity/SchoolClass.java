package com.computerquest.computer_quest_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "school_classes")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private Integer classLevel;
    private String board;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    private School school;

    @Transient
    private Long schoolId;

    @Transient
    private String schoolName;

    @Transient
    private Long adminId;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public SchoolClass() {
    }

    public SchoolClass(String className, Integer classLevel, String board) {
        this.className = className;
        this.classLevel = classLevel;
        this.board = board;
    }

    public SchoolClass(String className, Integer classLevel, String board, School school) {
        this.className = className;
        this.classLevel = classLevel;
        this.board = board;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
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
}
