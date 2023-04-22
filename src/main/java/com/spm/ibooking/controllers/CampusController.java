package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.CampusBo;
import com.spm.ibooking.models.dto.CampusDto;
import com.spm.ibooking.services.CampusService;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {
    
    @Autowired
    private CampusService campusService;

    @GetMapping
    public ResponseEntity<List<CampusBo>> getAllCampuss() {
        List<CampusBo> campuses = campusService.getAllCampuss();
        return ResponseEntity.ok(campuses);
    }

    @GetMapping("/{campusId}")
    public ResponseEntity<CampusBo> getCampusById(@PathVariable Integer campusId) throws ResourceNotFoundException {
        CampusBo campus = campusService.getCampusById(campusId);
        return ResponseEntity.ok(campus);
    }

    @PostMapping
    public ResponseEntity<CampusBo> createCampus(@RequestBody CampusDto campusDto) {
        CampusBo createdCampus = campusService.createCampus(campusDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampus);
    }

    @PatchMapping("/{campusId}")
    public ResponseEntity<CampusBo> updateCampus(@PathVariable Integer campusId, @RequestBody CampusDto campusDto) throws ResourceNotFoundException {
        CampusBo updatedCampus = campusService.updateCampus(campusId, campusDto);
        return ResponseEntity.ok(updatedCampus);
    }

    @DeleteMapping("/{campusId}")
    public ResponseEntity<Void> deleteCampus(@PathVariable Integer campusId) throws ResourceNotFoundException {
        campusService.deleteCampus(campusId);
        return ResponseEntity.noContent().build();
    }
}
