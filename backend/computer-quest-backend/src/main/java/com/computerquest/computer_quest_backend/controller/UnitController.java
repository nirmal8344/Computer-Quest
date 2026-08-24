package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.service.UnitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/units")
@CrossOrigin
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.saveUnit(unit);
    }

    @GetMapping
    public List<Unit> getAllUnits(
            @RequestParam(required = false) String board,
            @RequestParam(required = false) Integer classLevel,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long adminId,
            @RequestParam(required = false) Long schoolId) {
        return unitService.getUnits(board, classLevel, userId, adminId, schoolId);
    }

    @PutMapping("/{id}")
    public Unit updateUnit(
            @PathVariable Long id,
            @RequestBody Unit unit) {

        return unitService.updateUnit(id, unit);
    }

    @DeleteMapping("/{id}")
    public String deleteUnit(@PathVariable Long id) {

        unitService.deleteUnit(id);

        return "Unit deleted successfully";
    }
}