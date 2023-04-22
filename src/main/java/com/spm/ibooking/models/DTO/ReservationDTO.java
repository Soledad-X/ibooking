package com.spm.ibooking.models.DTO;

import lombok.*;

import com.spm.ibooking.models.enums.ReservationStatus;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO implements Serializable {

    private Integer id;

    private Integer userId;

    private UserDTO user;

    private Integer seatId;

    private SeatDTO seat;

    private Timestamp startTime;

    private Timestamp endTime;

    private ReservationStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
