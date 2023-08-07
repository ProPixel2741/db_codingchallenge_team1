package com.db.grad.javaapi.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SecurityTest {
    @Test
    void testGetCoupon() {
        Security s = new Security();
        s.setCoupon(0);

        float expected = 0;
        float actual = s.getCoupon();

        assertEquals(expected, actual, 1);
    }

    @Test
    void testGetCurrency() {
        Security s = new Security();
        s.setCurrency("USD");
        
        String expected = "USD";
        String actual = s.getCurrency();

        assertEquals(expected, actual);
    }

    @Test
    void testGetCusip() {
        Security s = new Security();
        s.setCusip("sad68sad");
        
        String expected = "sad68sad";
        String actual = s.getCusip();

        assertEquals(expected, actual);
    }

    @Test
    void testGetFace_value() {
        Security s = new Security();
        s.setFace_value(1);
        
        float expected = 1;
        float actual = s.getFace_value();

        assertEquals(expected, actual, 1);
    }

    @Test
    void testGetId() {
        Security s = new Security();
        s.setId(2);
        
        int expected = 2;
        int actual = s.getId();

        assertEquals(expected, actual);
    }

    @Test
    void testGetIsin() {
        Security s = new Security();
        s.setIsin("sad68sadsad");

        String expected = "sad68sadsad";
        String actual = s.getIsin();

        assertEquals(expected, actual);
    }

    @Test
    void testGetIssuer_name() {
        Security s = new Security();
        s.setIssuer_name("Amazon");

        String expected = "Amazon";
        String actual = s.getIssuer_name();

        assertEquals(expected, actual);
    }

    @Test
    void testGetMaturity_date() {
        Security s = new Security();
        s.setMaturity_date(new java.sql.Date(2023, 8, 4));

        java.sql.Date expected = new java.sql.Date(2023, 8, 4);
        java.sql.Date actual = s.getMaturity_date();

        assertEquals(expected, actual);    
    }

    @Test
    void testGetStatus() {
        Security s = new Security();
        s.setStatus("open");
        
        String expected = "open";
        String actual = s.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    void testGetType() {
        Security s = new Security();
        s.setType("type");

        String expected = "type";
        String actual = s.getType();

        assertEquals(expected, actual);
    }
}
