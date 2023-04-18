package com.spm.ibooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.entity.*;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByName(String name);
    List<Room> findByBuildingId(Integer buildingId);
    List<Room> findByBuildingName(String buildingName);
}
