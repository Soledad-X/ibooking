package com.spm.ibooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface CampusRepository extends JpaRepository<CampusDO, Integer> {
}
