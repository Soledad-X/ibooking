package com.spm.ibooking.models.BO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingBO {
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    private CampusBO campus;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}

