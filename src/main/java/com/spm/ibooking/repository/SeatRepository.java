package com.spm.ibooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.entity.*;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByRoomId(Integer roomId);
}

