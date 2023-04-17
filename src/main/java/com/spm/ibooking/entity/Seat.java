package com.spm.ibooking.entity;

import lombok.*;

import java.sql.Timestamp;

import javax.persistence.*;

@Data
@Entity
@Table(name = "seats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "has_power")
    private Boolean hasPower;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Column(name = "status_updated_at")
    @Setter(AccessLevel.NONE)
    private Timestamp statusUpdatedAt;

    @PreUpdate
    protected void onUpdate() {
        statusUpdatedAt = new Timestamp(System.currentTimeMillis());
    }
}

