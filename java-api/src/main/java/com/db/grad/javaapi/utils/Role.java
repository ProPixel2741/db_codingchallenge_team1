package com.db.grad.javaapi.utils;

public enum Role {
    ADMIN("ADMIN"), USER("USER");
    private String code;

    private Role(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
