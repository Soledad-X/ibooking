package com.spm.ibooking.models.po;

import lombok.*;

import java.sql.Timestamp;

import com.spm.ibooking.models.enums.SeatStatus;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(name = "has_power", nullable = false)
    private Boolean hasPower;
  
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Column(name = "status_updated_at", insertable = false, updatable = false)
    private Timestamp statusUpdatedAt;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

}

