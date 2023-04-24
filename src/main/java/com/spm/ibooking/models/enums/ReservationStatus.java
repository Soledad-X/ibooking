package com.spm.ibooking.models.enums;

public enum ReservationStatus {
    CONFIRMED("确定"),
    CANCELED("取消"),
    PENDING("等待");

    private final String name;

    ReservationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
