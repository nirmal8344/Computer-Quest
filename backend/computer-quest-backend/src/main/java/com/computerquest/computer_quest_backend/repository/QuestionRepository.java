package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByUnitAndChapterAndMission(
            String unit,
            String chapter,
            Integer mission
    );

    List<Question> findByBoardAndClassLevelAndUnitAndChapterAndMission(
            String board,
            Integer classLevel,
            String unit,
            String chapter,
            Integer mission
    );

    List<Question> findBySchool_IdAndBoardAndClassLevelAndUnitAndChapterAndMission(
            Long schoolId,
            String board,
            Integer classLevel,
            String unit,
            String chapter,
            Integer mission
    );

    List<Question> findBySchoolIsNullAndBoardAndClassLevelAndUnitAndChapterAndMission(
            String board,
            Integer classLevel,
            String unit,
            String chapter,
            Integer mission
    );

    List<Question> findBySchool_IdAndUnitAndChapterAndMission(
            Long schoolId,
            String unit,
            String chapter,
            Integer mission
    );

    List<Question> findBySchoolIsNullAndUnitAndChapterAndMission(
            String unit,
            String chapter,
            Integer mission
    );

    List<Question> findBySchool_Id(Long schoolId);

    long countBySchool_Id(Long schoolId);

    boolean existsByQuestionTextContaining(String keyword);

    List<Question> findByQuestionTextContaining(String keyword);

    List<Question> findBySchoolIsNull();

    @Query(value = """
            SELECT *
            FROM questions
            WHERE mission = :mission
            ORDER BY RANDOM()
            LIMIT 5
            """, nativeQuery = true)
    List<Question> findRandomQuestions(Integer mission);
}