package com.db.grad.javaapi.entity;

public class ErrorResponse {
    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
