package com.spm.ibooking.models.bo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomBo {

    private Long id;

    private String name;

    private BuildingBo building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
