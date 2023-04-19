package com.spm.ibooking.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.entity.Building;
import com.spm.ibooking.exception.ResourceNotFoundException;
import com.spm.ibooking.repository.BuildingRepository;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingById(Integer id) {
        return buildingRepository.findById(id).orElse(null);
    }

    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public Building updateBuilding(Integer id, Building building) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            Building existingBuilding = optionalBuilding.get();
            existingBuilding.setName(building.getName());
            existingBuilding.setAlias(building.getAlias());
            existingBuilding.setFloor(building.getFloor());
            existingBuilding.setCampus(building.getCampus());
            // set other fields you want to update
            return buildingRepository.save(existingBuilding);
        }
        throw new ResourceNotFoundException("Building not found with id " + id);
    }

    public void deleteBuilding(Integer id) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            buildingRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Building not found with id " + id);
        }
    }
}

