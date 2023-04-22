package com.spm.ibooking.models.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Integer id;

    private String name;

    private Integer buldingId;

    private BuildingDTO building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
