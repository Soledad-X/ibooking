package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.BuildingDO;
import com.spm.ibooking.models.DTO.BuildingDTO;
import com.spm.ibooking.services.BuildingService;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<BuildingDO>> getAllBuildings() {
        List<BuildingDO> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

    @GetMapping("/{buildingId}")
    public ResponseEntity<BuildingDO> getBuildingById(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        BuildingDO building = buildingService.getBuildingById(buildingId);
        return ResponseEntity.ok(building);
    }

    @PostMapping
    public ResponseEntity<BuildingDO> createBuilding(@RequestBody BuildingDTO building) {
        BuildingDO createdBuilding = buildingService.createBuilding(building);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuilding);
    }

    @PutMapping("/{buildingId}")
    public ResponseEntity<BuildingDO> updateBuilding(@PathVariable Integer buildingId, @RequestBody BuildingDTO building) throws ResourceNotFoundException {
        BuildingDO updatedBuilding = buildingService.updateBuilding(buildingId, building);
        return ResponseEntity.ok(updatedBuilding);
    }

    @DeleteMapping("/{buildingId}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        buildingService.deleteBuilding(buildingId);
        return ResponseEntity.noContent().build();
    }
}
