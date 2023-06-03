package com.spm.ibooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.entity.Campus;


public interface CampusRepository extends JpaRepository<Campus, Integer> {
    boolean existsByName(String name);
    Optional<Campus> findByName(String name);
}
