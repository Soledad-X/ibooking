package com.spm.ibooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spm.ibooking.models.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    boolean existsByName(String name);

    Optional<Room> findByName(String name);
}
