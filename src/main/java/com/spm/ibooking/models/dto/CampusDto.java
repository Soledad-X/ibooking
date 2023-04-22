package com.spm.ibooking.models.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusDto implements Serializable{
    
    private Integer id;

    private String name;

    private String address;

    private String city;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
    private List<BuildingDto> buildings = new ArrayList<>();
    
}

