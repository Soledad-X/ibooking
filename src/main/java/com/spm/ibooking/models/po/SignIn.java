package com.spm.ibooking.models.po;

import lombok.*;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sign_ins")
public class SignIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    // @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Integer status;

    @Column(nullable = false, updatable = false)
    private Timestamp startTime;

    private Timestamp signInTime;

    private Timestamp signOutTime;

    @Column(nullable = false, updatable = false)
    private Timestamp statusUpdatedAt;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
