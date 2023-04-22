package com.spm.ibooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.po.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByRoomId(Integer roomId);
}

