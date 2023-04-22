package com.spm.ibooking.models.dto;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDto implements Serializable{
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    private Integer campusId;
    
    private CampusDto campus;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}

