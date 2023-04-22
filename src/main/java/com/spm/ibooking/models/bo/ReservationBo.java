package com.spm.ibooking.models.bo;

import lombok.*;

import com.spm.ibooking.models.enums.ReservationStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationBo {

    private Long id;

    private UserBo user;

    private SeatBo seat;

    private Timestamp startTime;

    private Timestamp endTime;

    private ReservationStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
