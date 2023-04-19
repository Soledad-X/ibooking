package com.spm.ibooking.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.entity.Room;
import com.spm.ibooking.exception.ResourceNotFoundException;
import com.spm.ibooking.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Integer id, Room room) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setName(room.getName());
            existingRoom.setBuilding(room.getBuilding());
            existingRoom.setFloor(room.getFloor());
            return roomRepository.save(existingRoom);
        }
        throw new ResourceNotFoundException("Room not found with id " + id);
    }

    public void deleteRoom(Integer id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            roomRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Room not found with id " + id);
        }
    }
}

