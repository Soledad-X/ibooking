package com.spm.ibooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);
}

