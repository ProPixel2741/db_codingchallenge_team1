package com.db.grad.javaapi.entity;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class JwtRequestTest {

    @Test
    public void testJwtRequest() {
        JwtRequest jwtRequest = new JwtRequest("USER", "PASS");

        Assertions.assertEquals(jwtRequest.getUsername(), "USER");
        Assertions.assertEquals(jwtRequest.getPassword(), "PASS");
    }

    @Test
    public void testGetUsername() {
        JwtRequest jwtRequest = new JwtRequest("USER", "PASS");

        jwtRequest.setUsername("USER2");

        Assertions.assertEquals(jwtRequest.getUsername(), "USER2");
    }

    @Test
    public void testGetPassword() {
        JwtRequest jwtRequest = new JwtRequest("USER", "PASS");

        jwtRequest.setPassword("PASS2");

        Assertions.assertEquals(jwtRequest.getPassword(), "PASS2");
    }

    @Test
    public void testToString() {
        JwtRequest jwtRequest = new JwtRequest("USER", "PASS");

        Assertions.assertEquals(jwtRequest.toString(), "JwtRequest(username=USER, password=PASS)");
    }
}
