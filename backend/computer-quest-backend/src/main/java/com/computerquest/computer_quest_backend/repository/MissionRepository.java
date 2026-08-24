package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findByChapter_Id(Long chapterId);

    List<Mission> findByChapterBoardAndChapterClassLevel(String board, Integer classLevel);

    List<Mission> findBySchool_Id(Long schoolId);

    List<Mission> findBySchoolIsNull();

    List<Mission> findBySchool_IdAndChapterBoardAndChapterClassLevel(Long schoolId, String board, Integer classLevel);

    List<Mission> findBySchoolIsNullAndChapterBoardAndChapterClassLevel(String board, Integer classLevel);
}