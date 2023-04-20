package com.spm.ibooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface ReservationRepository extends JpaRepository<ReservationDO, Integer> {
    List<ReservationDO> findByUserId(Integer userId);
    List<ReservationDO> findBySeatId(Integer seatId);
}
