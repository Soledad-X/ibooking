package com.spm.ibooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.po.Campus;

public interface CampusRepository extends JpaRepository<Campus, Integer> {
}
