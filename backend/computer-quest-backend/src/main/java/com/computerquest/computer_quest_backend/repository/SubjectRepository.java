package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findBySchoolIsNullAndBoardAndClassLevel(String board, Integer classLevel);

    List<Subject> findBySchool_IdAndBoardAndClassLevel(Long schoolId, String board, Integer classLevel);

    List<Subject> findByBoardAndClassLevel(String board, Integer classLevel);

    Optional<Subject> findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(String board, Integer classLevel, String subjectName);

    boolean existsBySchoolIsNullAndBoardAndClassLevel(String board, Integer classLevel);

    boolean existsBySchoolIsNullAndBoardAndClassLevelAndSubjectName(String board, Integer classLevel, String subjectName);

    List<Subject> findBySchoolIsNull();
}
