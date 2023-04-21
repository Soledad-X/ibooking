package com.spm.ibooking.models.BO;

import lombok.*;

import java.sql.Timestamp;

import com.spm.ibooking.models.enums.SeatStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatBO {

    private Integer id;

    private RoomBO room;

    private Boolean hasPower;

    private SeatStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}

