package com.spm.ibooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spm.ibooking.models.vo.CampusVO;
import com.spm.ibooking.services.CampusService;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {
    
    @Autowired
    private CampusService campusService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getAll() {
        return campusService.getAll();
    }

    @GetMapping("/{campusId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getById(@PathVariable Integer campusId) {        
        return campusService.getById(campusId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String create(@RequestBody CampusVO campusVO) {        
        return campusService.create(campusVO);
    }

    @PatchMapping("/{campusId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String update(@PathVariable Integer campusId, @RequestBody CampusVO campusVO) {
        return campusService.update(campusId, campusVO);
    }

    @DeleteMapping("/{campusId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public String delete(@PathVariable Integer campusId) {
        campusService.delete(campusId);
        return null;
    }
}
