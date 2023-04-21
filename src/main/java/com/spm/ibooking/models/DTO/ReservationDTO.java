package com.spm.ibooking.models.DTO;

import lombok.*;

import com.spm.ibooking.models.enums.ReservationStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long id;

    private UserDTO user;

    private SeatDTO seat;

    private Timestamp startTime;

    private Timestamp endTime;

    private ReservationStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
