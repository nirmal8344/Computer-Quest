package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    Optional<Chapter> findByChapterNumber(Integer chapterNumber);

    List<Chapter> findByBoardAndClassLevel(String board, Integer classLevel);

    Optional<Chapter> findByBoardAndClassLevelAndChapterNumber(String board, Integer classLevel, Integer chapterNumber);

    List<Chapter> findBySchool_IdAndBoardAndClassLevel(Long schoolId, String board, Integer classLevel);

    List<Chapter> findBySchoolIsNullAndBoardAndClassLevel(String board, Integer classLevel);

    Optional<Chapter> findBySchool_IdAndBoardAndClassLevelAndChapterNumber(Long schoolId, String board, Integer classLevel, Integer chapterNumber);

    Optional<Chapter> findBySchoolIsNullAndBoardAndClassLevelAndChapterNumber(String board, Integer classLevel, Integer chapterNumber);

    List<Chapter> findBySchool_Id(Long schoolId);

    List<Chapter> findBySchoolIsNull();
}