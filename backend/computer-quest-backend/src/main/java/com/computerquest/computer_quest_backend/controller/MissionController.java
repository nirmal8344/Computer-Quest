package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.service.MissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
@CrossOrigin
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping
    public Mission createMission(@RequestBody Mission mission) {
        return missionService.saveMission(mission);
    }

    @GetMapping
    public List<Mission> getAllMissions(
            @RequestParam(required = false) String board,
            @RequestParam(required = false) Integer classLevel,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long adminId,
            @RequestParam(required = false) Long schoolId) {

        return missionService.getMissions(board, classLevel, userId, adminId, schoolId);
    }

    @PutMapping("/{id}")
    public Mission updateMission(
            @PathVariable Long id,
            @RequestBody Mission mission) {

        return missionService.updateMission(id, mission);
    }

    @DeleteMapping("/{id}")
    public String deleteMission(@PathVariable Long id) {

        missionService.deleteMission(id);

        return "Mission deleted successfully";
    }
}