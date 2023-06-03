package com.spm.ibooking.models.enums;

public enum ReservationStatus {
    CONFIRMED("确定"),
    CANCELED("取消"),
    PENDING("等待");

    private final String status;

    ReservationStatus(String status) {
        this.status = status;
    }

    public String getstatus() {
        return status;
    }
}
