package com.spm.ibooking.models.BO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusBO {
    
    private Integer id;

    private String name;

    private String address;

    private String city;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
    @JsonIgnoreProperties(value = {"buildings"})
    private List<BuildingBO> buildings = new ArrayList<>();
    
    public void addBuilding(BuildingBO building) {
        buildings.add(building);
        building.setCampus(this);
    }
    
    public void removeBuilding(BuildingBO building) {
        buildings.remove(building);
        building.setCampus(null);
    }
}

