package com.spm.ibooking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface RoomRepository extends JpaRepository<RoomDO, Integer> {
    Optional<RoomDO> findByName(String name);
    List<RoomDO> findByBuildingId(Integer buildingId);
    List<RoomDO> findByBuildingName(String buildingName);
}
