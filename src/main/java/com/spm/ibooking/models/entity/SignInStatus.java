package com.spm.ibooking.models.entity;

public enum SignInStatus {
    WAITING("等待"),
    SIGNED_IN("签到"),
    SIGNED_OUT("签退"),
    TIMED_OUT("超时");

    private String name;

    SignInStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
