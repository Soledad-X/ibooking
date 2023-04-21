package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DTO.BuildingDTO;
import com.spm.ibooking.models.PO.Building;
import com.spm.ibooking.repositories.BuildingRepository;
import com.spm.ibooking.repositories.CampusRepository;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private CampusRepository campusRepository;
    
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingById(Integer id) {
        return buildingRepository.findById(id).orElse(null);
    }

    public Building createBuilding(BuildingDTO buildingDTO) {
        Building building = new Building();
        building.setName(buildingDTO.getName());
        building.setAlias(buildingDTO.getAlias());
        building.setFloor(buildingDTO.getFloor());
        building.setCampus(campusRepository.findById(buildingDTO.getCampusId()).orElse(null));        
        return buildingRepository.save(building);
    }

    public Building updateBuilding(Integer id, BuildingDTO building) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            Building existingBuilding = optionalBuilding.get();
            existingBuilding.setName(building.getName());
            existingBuilding.setAlias(building.getAlias());
            existingBuilding.setFloor(building.getFloor());
            existingBuilding.setCampus(campusRepository.findById(building.getCampusId()).orElse(null));
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
