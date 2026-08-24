package com.computerquest.computer_quest_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitName;
    private Integer unitNumber;

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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Unit() {
    }

    public Unit(String unitName, Integer unitNumber) {
        this.unitName = unitName;
        this.unitNumber = unitNumber;
    }

    public Unit(String unitName, Integer unitNumber, String board, Integer classLevel) {
        this.unitName = unitName;
        this.unitNumber = unitNumber;
        this.board = board;
        this.classLevel = classLevel;
    }

    public Unit(String unitName, Integer unitNumber, String board, Integer classLevel, School school) {
        this.unitName = unitName;
        this.unitNumber = unitNumber;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
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
}