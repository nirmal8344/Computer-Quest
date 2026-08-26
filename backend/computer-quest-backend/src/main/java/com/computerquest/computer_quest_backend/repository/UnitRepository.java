package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findByBoardAndClassLevel(String board, Integer classLevel);

    List<Unit> findBySchool_IdAndBoardAndClassLevel(Long schoolId, String board, Integer classLevel);

    List<Unit> findBySchoolIsNullAndBoardAndClassLevel(String board, Integer classLevel);

    boolean existsBySchoolIsNullAndBoardAndClassLevel(String board, Integer classLevel);

    List<Unit> findBySchool_Id(Long schoolId);

    List<Unit> findBySchoolIsNull();
}