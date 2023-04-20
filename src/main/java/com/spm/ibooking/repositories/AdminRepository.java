package com.spm.ibooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface AdminRepository extends JpaRepository<AdminDO, Integer> {
    Optional<AdminDO> findByUsername(String username);
    Optional<AdminDO> findByEmail(String email);
    Optional<AdminDO> findByPhone(String phone);
}
