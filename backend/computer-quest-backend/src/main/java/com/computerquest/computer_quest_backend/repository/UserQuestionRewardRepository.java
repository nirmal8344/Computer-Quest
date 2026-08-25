package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.UserQuestionReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionRewardRepository extends JpaRepository<UserQuestionReward, Long> {
    boolean existsByUserIdAndQuestionId(Long userId, Long questionId);
}
