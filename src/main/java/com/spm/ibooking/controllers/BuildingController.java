package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.BuildingBO;
import com.spm.ibooking.models.DTO.BuildingDTO;
import com.spm.ibooking.services.BuildingService;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<BuildingBO>> getAllBuildings() {
        List<BuildingBO> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

    @GetMapping("/{buildingId}")
    public ResponseEntity<BuildingBO> getBuildingById(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        BuildingBO building = buildingService.getBuildingById(buildingId);
        return ResponseEntity.ok(building);
    }

    @PostMapping
    public ResponseEntity<BuildingBO> createBuilding(@RequestBody BuildingDTO buildingDTO) {
        BuildingBO createdBuilding = buildingService.createBuilding(buildingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuilding);
    }

    @PatchMapping("/{buildingId}")
    public ResponseEntity<BuildingBO> updateBuilding(@PathVariable Integer buildingId, @RequestBody BuildingDTO buildingDTO) throws ResourceNotFoundException {
        BuildingBO updatedBuilding = buildingService.updateBuilding(buildingId, buildingDTO);
        return ResponseEntity.ok(updatedBuilding);
    }

    @DeleteMapping("/{buildingId}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        buildingService.deleteBuilding(buildingId);
        return ResponseEntity.noContent().build();
    }
}
