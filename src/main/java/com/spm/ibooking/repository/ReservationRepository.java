package com.spm.ibooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.entity.*;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(Integer userId);
    List<Reservation> findBySeatId(Integer seatId);
}
