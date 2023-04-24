package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.dto.BuildingDto;
import com.spm.ibooking.models.dto.RoomDto;
import com.spm.ibooking.models.dto.SeatDto;
import com.spm.ibooking.models.po.Room;
import com.spm.ibooking.repositories.BuildingRepository;
import com.spm.ibooking.repositories.RoomRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    public List<RoomDto> getAll() {
        return BeanUtils.convertListTo(roomRepository.findAll(), RoomDto::new, true,
            (s, t) -> {
                t.setBuilding(BeanUtils.convertTo(s.getBuilding(), BuildingDto::new, true));
                t.setSeats(BeanUtils.convertListTo(s.getSeats(), SeatDto::new, true));
            });
    }

    public RoomDto getById(Integer id) {
        return BeanUtils.convertTo(roomRepository.findById(id).orElse(null), RoomDto::new, true,
            (s, t) -> {
                t.setBuilding(BeanUtils.convertTo(s.getBuilding(), BuildingDto::new, true));
                t.setSeats(BeanUtils.convertListTo(s.getSeats(), SeatDto::new, true));
            });
    }

    public RoomDto create(RoomDto RoomDto) {
        Room room = BeanUtils.convertTo(RoomDto, Room::new, true,
            (s, t) -> t.setBuilding(buildingRepository.findById(RoomDto.getBuildingId()).orElse(null)));
        return BeanUtils.convertTo(roomRepository.save(room), RoomDto::new, true,
            (s, t) -> {
                t.setBuilding(BeanUtils.convertTo(s.getBuilding(), BuildingDto::new, true));
                t.setSeats(BeanUtils.convertListTo(s.getSeats(), SeatDto::new, true));
            });
    }

    public RoomDto update(Integer id, RoomDto RoomDto) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            BeanUtils.copyTo(RoomDto, room, true,
                (s, t) -> t.setBuilding(buildingRepository.findById(RoomDto.getBuildingId()).orElse(null)));
            return BeanUtils.convertTo(roomRepository.save(room), RoomDto::new, true,
                (s, t) -> {
                    t.setBuilding(BeanUtils.convertTo(s.getBuilding(), BuildingDto::new, true));
                    t.setSeats(BeanUtils.convertListTo(s.getSeats(), SeatDto::new, true));
                });
        }
        throw new ResourceNotFoundException("Room not found with id " + id);
    }

    public void delete(Integer id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            roomRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Room not found with id " + id);
        }
    }
}

