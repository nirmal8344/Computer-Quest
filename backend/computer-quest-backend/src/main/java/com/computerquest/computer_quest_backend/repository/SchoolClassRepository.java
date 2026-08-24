package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    List<SchoolClass> findBySchool_Id(Long schoolId);

    List<SchoolClass> findBySchoolIsNull();

    List<SchoolClass> findBySchool_IdAndBoard(Long schoolId, String board);

    List<SchoolClass> findBySchoolIsNullAndBoard(String board);

    Optional<SchoolClass> findBySchool_IdAndBoardAndClassLevel(Long schoolId, String board, Integer classLevel);

    Optional<SchoolClass> findBySchoolIsNullAndBoardAndClassLevel(String board, Integer classLevel);
}
