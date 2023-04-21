package com.spm.ibooking.models.BO;

import lombok.*;

import com.spm.ibooking.models.enums.SignInStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInBO {

    private Long id;

    private ReservationBO reservation;

    private SignInStatus status;

    private Timestamp startTime;

    private Timestamp signInTime;

    private Timestamp signOutTime;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}
