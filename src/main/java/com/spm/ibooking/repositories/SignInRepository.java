package com.spm.ibooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.DO.*;

public interface SignInRepository extends JpaRepository<SignInDO, Integer> {
    List<SignInDO> findByReservationId(Integer reservationId);
}
