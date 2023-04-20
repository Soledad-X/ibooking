package com.spm.ibooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface UserRepository extends JpaRepository<UserDO, Integer> {
    Optional<UserDO> findByUsername(String username);
    Optional<UserDO> findByEmail(String email);
    Optional<UserDO> findByPhone(String phone);
}

