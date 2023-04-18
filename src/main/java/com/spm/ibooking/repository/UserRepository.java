package com.spm.ibooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.entity.*;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
}

