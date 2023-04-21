package com.spm.ibooking.models.BO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomBO {

    private Long id;

    private String name;

    private BuildingBO building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
