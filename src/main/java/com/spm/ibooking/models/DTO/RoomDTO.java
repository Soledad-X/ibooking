package com.spm.ibooking.models.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Long id;

    private String name;

    private BuildingDTO building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
