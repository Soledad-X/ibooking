package com.spm.ibooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // List<Reservation> findByUserId(Integer userId);
    // List<Reservation> findBySeatId(Integer seatId);
}
