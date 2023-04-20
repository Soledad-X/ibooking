package com.spm.ibooking.models.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sign_ins")
public class SignIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

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
