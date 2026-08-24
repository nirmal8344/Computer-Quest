package com.computerquest.computer_quest_backend.repository;

import com.computerquest.computer_quest_backend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findAllByUsername(String username);

    Optional<Admin> findFirstByUsername(String username);

    List<Admin> findBySchoolId(Long schoolId);
}