package com.spm.ibooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface SeatRepository extends JpaRepository<SeatDO, Integer> {
    List<SeatDO> findByRoomId(Integer roomId);
}

