package com.spm.ibooking.models.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusDTO {
    
    private Integer id;

    private String name;

    private String address;

    private String city;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
    private List<BuildingDTO> buildings = new ArrayList<>();
    
    public void addBuilding(BuildingDTO building) {
        buildings.add(building);
        building.setCampus(this);
    }
    
    public void removeBuilding(BuildingDTO building) {
        buildings.remove(building);
        building.setCampus(null);
    }
}

