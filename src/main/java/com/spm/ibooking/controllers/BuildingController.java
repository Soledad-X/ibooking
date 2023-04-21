package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DTO.BuildingDTO;
import com.spm.ibooking.models.PO.Building;
import com.spm.ibooking.services.BuildingService;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<Building>> getAllBuildings() {
        List<Building> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

    @GetMapping("/{buildingId}")
    public ResponseEntity<Building> getBuildingById(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        Building building = buildingService.getBuildingById(buildingId);
        return ResponseEntity.ok(building);
    }

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody BuildingDTO building) {
        Building createdBuilding = buildingService.createBuilding(building);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuilding);
    }

    @PutMapping("/{buildingId}")
    public ResponseEntity<Building> updateBuilding(@PathVariable Integer buildingId, @RequestBody BuildingDTO building) throws ResourceNotFoundException {
        Building updatedBuilding = buildingService.updateBuilding(buildingId, building);
        return ResponseEntity.ok(updatedBuilding);
    }

    @DeleteMapping("/{buildingId}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        buildingService.deleteBuilding(buildingId);
        return ResponseEntity.noContent().build();
    }
}
