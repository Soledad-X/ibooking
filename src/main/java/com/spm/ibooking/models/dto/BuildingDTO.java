package com.spm.ibooking.models.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {
    private String name;
    private String alias;
    private Integer floor;
    private Integer campusId;
}

