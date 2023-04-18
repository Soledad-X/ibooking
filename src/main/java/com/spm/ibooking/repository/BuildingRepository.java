package com.spm.ibooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.entity.*;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    Optional<Building> findByName(String name);
}
