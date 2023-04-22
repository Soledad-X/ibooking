package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.dto.CampusDto;
import com.spm.ibooking.models.dto.BuildingDto;
import com.spm.ibooking.models.po.Building;
import com.spm.ibooking.repositories.BuildingRepository;
import com.spm.ibooking.repositories.CampusRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private CampusRepository campusRepository;
    
    public List<BuildingDto> getAll() {
        return BeanUtils.convertListTo(buildingRepository.findAll(), BuildingDto::new, true,
            (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusDto::new, true)));
    }

    public BuildingDto getById(Integer id) {
        return BeanUtils.convertTo(buildingRepository.findById(id).orElse(null), BuildingDto::new, true,
            (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusDto::new, true)));
    }

    public BuildingDto create(BuildingDto buildingDto) {
        Building building = BeanUtils.convertTo(buildingDto, Building::new, true,
            (s, t) -> t.setCampus(campusRepository.findById(s.getCampusId()).orElse(null)));        
        return BeanUtils.convertTo(buildingRepository.save(building), BuildingDto::new, true);
    }

    public BuildingDto update(Integer id, BuildingDto buildingDto) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            Building building = optionalBuilding.get();
            BeanUtils.CopyTo(buildingDto, building, true, 
                (s, t) -> t.setCampus(campusRepository.findById(s.getCampusId()).orElse(null)));
            return BeanUtils.convertTo(buildingRepository.save(building), BuildingDto::new, true,
                (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusDto::new, true)));
        }
        throw new ResourceNotFoundException("Building not found with id " + id);
    }

    public void delete(Integer id) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            buildingRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Building not found with id " + id);
        }
    }
}
