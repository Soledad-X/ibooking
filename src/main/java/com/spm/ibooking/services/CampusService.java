package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.dto.BuildingDto;
import com.spm.ibooking.models.dto.CampusDto;
import com.spm.ibooking.models.po.Campus;
import com.spm.ibooking.repositories.CampusRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

    public List<CampusDto> getAll() {
        return BeanUtils.convertListTo(campusRepository.findAll(), CampusDto::new, true,
            (s, t) -> t.setBuildings(BeanUtils.convertListTo(s.getBuildings(), BuildingDto::new)));
    }

    public CampusDto getById(Integer id) {
        return BeanUtils.convertTo(campusRepository.findById(id).orElse(null), CampusDto::new, true,
        (s, t) -> t.setBuildings(BeanUtils.convertListTo(s.getBuildings(), BuildingDto::new)));
    }

    public CampusDto create(CampusDto campusDto) {
        Campus campus = BeanUtils.convertTo(campusDto, Campus::new, true);
        return BeanUtils.convertTo(campusRepository.save(campus), CampusDto::new, true);
    }

    public CampusDto update(Integer id, CampusDto campusDto) {
        Optional<Campus> optionalCampus = campusRepository.findById(id);
        if (optionalCampus.isPresent()) {
            Campus campus = optionalCampus.get();
            BeanUtils.copyTo(campusDto, campus, true);
            campus = BeanUtils.convertTo(campusDto, Campus::new, true);
            campus.setId(id); 
            // set other fields you want to update
            return BeanUtils.convertTo(campusRepository.save(campus), CampusDto::new, true);
        }
        throw new ResourceNotFoundException("Campus not found with id " + id);
    }

    public void delete(Integer id) {
        Optional<Campus> optionalCampus = campusRepository.findById(id);
        if (optionalCampus.isPresent()) {
            campusRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Campus not found with id " + id);
        }
    }
}

