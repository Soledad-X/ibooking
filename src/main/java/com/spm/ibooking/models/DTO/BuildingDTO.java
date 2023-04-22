package com.spm.ibooking.models.DTO;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO implements Serializable{
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    private Integer campusId;
    
    private CampusDTO campus;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}

