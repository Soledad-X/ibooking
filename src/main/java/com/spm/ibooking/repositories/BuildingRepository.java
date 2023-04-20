package com.spm.ibooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface BuildingRepository extends JpaRepository<BuildingDO, Integer> {
    Optional<BuildingDO> findByName(String name);
}
