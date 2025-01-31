package com.db.grad.javaapi.entity;

public class JwtResponse {
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtResponse(token=" + token + ")";
    }
}
