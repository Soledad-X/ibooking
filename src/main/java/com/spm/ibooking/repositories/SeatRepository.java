package com.spm.ibooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    // List<Seat> findByRoomId(Integer roomId);
}

