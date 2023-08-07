package com.db.grad.javaapi.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CounterPartyTest {
    @Test
    void testGetId() {
        CounterParty c1 = new CounterParty();
        c1.setId(0);

        int expected = 0;
        int actual = c1.getId();
        
        assertEquals(expected, actual);
    }

    @Test
    void testGetName() {
        CounterParty c1 = new CounterParty();
        c1.setName("Samantha");

        String expected = "Samantha";
        String actual = c1.getName();
        
        assertEquals(expected, actual);
    }
}
