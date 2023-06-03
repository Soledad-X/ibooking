package com.spm.ibooking.models.enums;

public enum SeatStatus {
    UNDER_MAINTENANCE("待维修"),
    AVAILABLE("可使用");

    private final String status;

    SeatStatus(String status) {
        this.status = status;
    }

    public String getstatus() {
        return status;
    }
}