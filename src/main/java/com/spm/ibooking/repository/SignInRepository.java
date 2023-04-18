package com.spm.ibooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spm.ibooking.entity.*;

@Repository
public interface SignInRepository extends JpaRepository<SignIn, Integer> {
    List<SignIn> findByReservationId(Integer reservationId);
}
