package com.spm.ibooking.models.enums;

public enum SignInStatus {
    PENDING("等待"),
    SIGNED_IN("签到"),
    SIGNED_OUT("签退"),
    TIME_OUT("超时");

    private String status;

    SignInStatus(String status) {
        this.status = status;
    }

    public String getstatus() {
        return status;
    }
}
