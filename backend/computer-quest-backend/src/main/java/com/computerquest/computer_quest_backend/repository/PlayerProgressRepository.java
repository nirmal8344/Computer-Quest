package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.PlayerProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerProgressRepository extends JpaRepository<PlayerProgress, Long> {

    Optional<PlayerProgress> findByUserId(Long userId);

    Optional<PlayerProgress> findByUserIdAndSubject(Long userId, String subject);

    List<PlayerProgress> findAllByUserId(Long userId);

    List<PlayerProgress> findAllByOrderByXpDesc();

    List<PlayerProgress> findByUser_School_IdOrderByXpDesc(Long schoolId);

    List<PlayerProgress> findBySubjectOrderByXpDesc(String subject);

    List<PlayerProgress> findBySubjectAndUser_School_IdOrderByXpDesc(String subject, Long schoolId);

    List<PlayerProgress> findBySubjectAndUser_BoardAndUser_ClassLevelOrderByXpDesc(String subject, String board, Integer classLevel);

    @Query("SELECT pp FROM PlayerProgress pp WHERE pp.user.board = :board AND pp.user.classLevel = :classLevel ORDER BY pp.xp DESC")
    List<PlayerProgress> findByBoardAndClassLevelOrderByXpDesc(@Param("board") String board, @Param("classLevel") Integer classLevel);

    @Query("SELECT pp FROM PlayerProgress pp WHERE pp.user.id = :userId")
    List<PlayerProgress> findProgressByUserId(@Param("userId") Long userId);
}