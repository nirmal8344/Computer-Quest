package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findBySchoolId(Long schoolId);

    long countBySchoolId(Long schoolId);
}