package com.spm.ibooking.models.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    private CampusDTO campus;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}

