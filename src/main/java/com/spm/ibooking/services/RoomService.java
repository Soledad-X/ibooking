package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.RoomDO;
import com.spm.ibooking.repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomDO getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<RoomDO> getAllRooms() {
        return roomRepository.findAll();
    }

    public RoomDO createRoom(RoomDO room) {
        return roomRepository.save(room);
    }

    public RoomDO updateRoom(Integer id, RoomDO room) {
        Optional<RoomDO> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            RoomDO existingRoom = optionalRoom.get();
            existingRoom.setName(room.getName());
            existingRoom.setBuilding(room.getBuilding());
            existingRoom.setFloor(room.getFloor());
            return roomRepository.save(existingRoom);
        }
        throw new ResourceNotFoundException("Room not found with id " + id);
    }

    public void deleteRoom(Integer id) {
        Optional<RoomDO> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            roomRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Room not found with id " + id);
        }
    }
}

