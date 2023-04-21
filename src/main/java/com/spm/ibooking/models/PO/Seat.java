package com.spm.ibooking.models.PO;

import lombok.*;

import java.sql.Timestamp;

import javax.persistence.*;

import com.spm.ibooking.models.enums.SeatStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
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

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    @PreUpdate
    protected void onUpdate() {
        statusUpdatedAt = new Timestamp(System.currentTimeMillis());
    }
}

