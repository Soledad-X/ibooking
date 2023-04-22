package com.spm.ibooking.models.DTO;

import lombok.*;

import com.spm.ibooking.models.enums.SignInStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInDTO {

    private Integer id;

    private Integer reservationId;

    private ReservationDTO reservation;
    
    private SignInStatus status;

    private Timestamp startTime;

    private Timestamp signInTime;

    private Timestamp signOutTime;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
