package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.BuildingBO;
import com.spm.ibooking.models.BO.CampusBO;
import com.spm.ibooking.models.DTO.BuildingDTO;
import com.spm.ibooking.models.PO.Building;
import com.spm.ibooking.repositories.BuildingRepository;
import com.spm.ibooking.repositories.CampusRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private CampusRepository campusRepository;
    
    public List<BuildingBO> getAllBuildings() {
        return BeanUtils.convertListTo(buildingRepository.findAll(), BuildingBO::new, true,
            (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusBO::new, true)));
    }

    public BuildingBO getBuildingById(Integer id) {
        return BeanUtils.convertTo(buildingRepository.findById(id).orElse(null), BuildingBO::new, true,
            (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusBO::new, true)));
    }

    public BuildingBO createBuilding(BuildingDTO buildingDTO) {
        Building building = BeanUtils.convertTo(buildingDTO, Building::new, true,
            (s, t) -> t.setCampus(campusRepository.findById(s.getCampusId()).orElse(null)));        
        return BeanUtils.convertTo(buildingRepository.save(building), BuildingBO::new, true);
    }

    public BuildingBO updateBuilding(Integer id, BuildingDTO buildingDTO) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            Building building = optionalBuilding.get();
            BeanUtils.CopyTo(buildingDTO, building, true, 
                (s, t) -> t.setCampus(campusRepository.findById(s.getCampusId()).orElse(null)));
            return BeanUtils.convertTo(buildingRepository.save(building), BuildingBO::new, true,
                (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusBO::new, true)));
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

