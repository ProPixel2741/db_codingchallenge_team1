package com.db.grad.javaapi.entity;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class JwtResponseTest {

    @Test
    public void testJwtResponse() {
        JwtResponse jwtResponse = new JwtResponse("TOKEN");

        Assertions.assertEquals(jwtResponse.getToken(), new JwtResponse("TOKEN").getToken());
    }

    @Test
    public void testGetToken() {
        JwtResponse jwtResponse = new JwtResponse("TOKEN");

        jwtResponse.setToken("TOKEN1");

        Assertions.assertEquals(jwtResponse.getToken(), "TOKEN1");
    }
}
