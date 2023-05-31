package com.spm.ibooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.entity.SignIn;

public interface SignInRepository extends JpaRepository<SignIn, Integer> {
    List<SignIn> findByReservationId(Integer reservationId);
}
