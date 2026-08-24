package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.SchoolClass;
import com.computerquest.computer_quest_backend.service.SchoolClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/classes")
@CrossOrigin
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public SchoolClass createClass(@RequestBody SchoolClass schoolClass) {
        return schoolClassService.saveClass(schoolClass);
    }

    @GetMapping
    public List<SchoolClass> getClasses(
            @RequestParam(required = false) String board,
            @RequestParam(required = false) Long adminId,
            @RequestParam(required = false) Long schoolId) {
        return schoolClassService.getClasses(board, adminId, schoolId);
    }

    @PutMapping("/{id}")
    public SchoolClass updateClass(
            @PathVariable Long id,
            @RequestBody SchoolClass schoolClass) {
        return schoolClassService.updateClass(id, schoolClass);
    }

    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable Long id) {
        schoolClassService.deleteClass(id);
        return "Class deleted successfully";
    }
}
