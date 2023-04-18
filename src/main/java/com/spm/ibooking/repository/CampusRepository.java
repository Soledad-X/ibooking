package com.spm.ibooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spm.ibooking.entity.*;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {
}
