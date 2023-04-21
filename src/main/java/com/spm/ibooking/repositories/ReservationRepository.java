package com.spm.ibooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.PO.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(Integer userId);
    List<Reservation> findBySeatId(Integer seatId);
}
