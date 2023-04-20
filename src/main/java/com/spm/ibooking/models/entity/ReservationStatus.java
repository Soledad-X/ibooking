package com.spm.ibooking.models.entity;

public enum ReservationStatus {
    CONFIRMED("确定"),
    CANCELED("取消"),
    WAITING("等待");

    private final String name;

    ReservationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
