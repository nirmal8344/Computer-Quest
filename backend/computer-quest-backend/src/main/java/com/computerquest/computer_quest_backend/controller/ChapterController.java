package com.computerquest.computer_quest_backend.controller;

import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.service.ChapterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@CrossOrigin
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @PostMapping
    public Chapter createChapter(@RequestBody Chapter chapter) {
        return chapterService.saveChapter(chapter);
    }

    @GetMapping
    public List<Chapter> getAllChapters(
            @RequestParam(required = false) String board,
            @RequestParam(required = false) Integer classLevel,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long adminId,
            @RequestParam(required = false) Long schoolId) {

        return chapterService.getChapters(board, classLevel, userId, adminId, schoolId);
    }

    @PutMapping("/{id}")
    public Chapter updateChapter(
            @PathVariable Long id,
            @RequestBody Chapter chapter) {

        return chapterService.updateChapter(id, chapter);
    }

    @DeleteMapping("/{id}")
    public String deleteChapter(@PathVariable Long id) {

        chapterService.deleteChapter(id);

        return "Chapter deleted successfully";
    }
}