package com.spm.ibooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.ibooking.models.vo.CampusVO;
import com.spm.ibooking.services.CampusService;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {
    
    @Autowired
    private CampusService campusService;

    @GetMapping
    public String getAll() {
        return campusService.getAll();
    }

    @GetMapping("/{campusId}")
    public String getById(@PathVariable Integer campusId) {        
        return campusService.getById(campusId);
    }

    @GetMapping("/{campus_id}/buildings")
    public String getBuildingsById(@PathVariable("campus_id") Integer campusId) {
        return campusService.getBuildingsById(campusId);
    }

    @GetMapping("/name/{campus_name}/buildings")
    public String getBuildingsByName(@PathVariable("campus_name") String campusName) {
        return campusService.getBuildingsByName(campusName);
    }

    @PostMapping
    public String create(@RequestBody CampusVO campusVO) {        
        return campusService.create(campusVO);
    }

    @PatchMapping("/{campusId}")
    public String update(@PathVariable Integer campusId, @RequestBody CampusVO campusVO) {
        return campusService.update(campusId, campusVO);
    }

    @DeleteMapping("/{campusId}")
    public String delete(@PathVariable Integer campusId) {
        return campusService.delete(campusId);
    }
}
