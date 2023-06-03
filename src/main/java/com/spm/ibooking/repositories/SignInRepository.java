package com.spm.ibooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.entity.SignIn;

public interface SignInRepository extends JpaRepository<SignIn, Integer> {
    // List<SignIn> findByReservationId(Integer reservationId);
}
