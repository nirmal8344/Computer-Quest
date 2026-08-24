package com.computerquest.computer_quest_backend.service;

import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    public Optional<School> getSchoolByName(String name) {
        return schoolRepository.findByName(name);
    }
}
