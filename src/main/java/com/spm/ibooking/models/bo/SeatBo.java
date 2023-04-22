package com.spm.ibooking.models.bo;

import lombok.*;

import java.sql.Timestamp;

import com.spm.ibooking.models.enums.SeatStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatBo {

    private Integer id;

    private RoomBo room;

    private Boolean hasPower;

    private SeatStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}

