package com.spm.ibooking.models.DO;

import lombok.*;

import javax.persistence.*;

import com.spm.ibooking.models.enums.SignInStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sign_ins")
public class SignInDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private ReservationDO reservation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SignInStatus status;

    @Column(nullable = false, updatable = false)
    private Timestamp startTime;

    private Timestamp signInTime;

    private Timestamp signOutTime;

    @Column(nullable = false, updatable = false)
    private Timestamp statusUpdatedAt;
}
