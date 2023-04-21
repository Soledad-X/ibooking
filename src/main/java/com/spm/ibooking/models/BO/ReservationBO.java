package com.spm.ibooking.models.BO;

import lombok.*;

import com.spm.ibooking.models.enums.ReservationStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationBO {

    private Long id;

    private UserBO user;

    private SeatBO seat;

    private Timestamp startTime;

    private Timestamp endTime;

    private ReservationStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
