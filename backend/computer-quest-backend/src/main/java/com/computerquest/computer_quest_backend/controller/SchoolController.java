package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }
}
