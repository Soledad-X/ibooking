package com.spm.ibooking.entity;

public enum SeatStatus {
    UNDER_MAINTENANCE("待维修"),
    AVAILABLE("可使用");

    private final String displayName;

    SeatStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}