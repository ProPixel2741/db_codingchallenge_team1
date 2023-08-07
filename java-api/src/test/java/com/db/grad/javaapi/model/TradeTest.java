package com.db.grad.javaapi.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TradeTest {
    @Test
    void testGetBook_id() {
        Trade t = new Trade();
        Book b = new Book();
        t.setBook(b);
        
        Book expected = b;
        Book actual = t.getBook();

        assertEquals(expected, actual);
    }

    @Test
    void testGetBuy_sell() {
        Trade t = new Trade();
        t.setBuy_sell("buy");

        String expected = "buy";
        String actual = t.getBuy_sell();

        assertEquals(expected, actual);
    }

    @Test
    void testGetCounter_party_id() {
        Trade t = new Trade();
        CounterParty c = new CounterParty();
        t.setCounterParty(c);

        CounterParty expected = c;
        CounterParty actual = t.getCounterParty();

        assertEquals(expected, actual);
    }

    @Test
    void testGetCurrency() {
        Trade t = new Trade();
        t.setCurrency("USD");
        
        String expected = "USD";
        String actual = t.getCurrency();

        assertEquals(expected, actual);
    }

    @Test
    void testGetId() {
        Trade t = new Trade();
        t.setId(2);
        
        int expected = 2;
        int actual = t.getId();

        assertEquals(expected, actual);
    }

    @Test
    void testGetQuantity() {
        Trade t = new Trade();
        t.setQuantity(3);
        
        int expected = 3;
        int actual = t.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSecurity_id() {
        Trade t = new Trade();
        Security s = new Security();
        t.setSecurity(s);
        
        Security expected = s;
        Security actual = t.getSecurity();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSettlement_date() {
        Trade t = new Trade();
        t.setSettlement_date(new java.sql.Date(2023, 8,4));
        
        java.sql.Date expected = new java.sql.Date(2023, 8, 4);
        java.sql.Date actual = t.getSettlement_date();

        assertEquals(expected, actual);
    }

    @Test
    void testGetTrade_date() {
        Trade t = new Trade();
        t.setTrade_date(new java.sql.Date(2023, 8, 5));
        
        java.sql.Date expected = new java.sql.Date(2023, 8, 5);
        java.sql.Date actual = t.getTrade_date();

        assertEquals(expected, actual);
    }

    @Test
    void testGetUnit_price() {
        Trade t = new Trade();
        t.setUnit_price(5);
        
        float expected = 5;
        float actual = t.getUnit_price();

        assertEquals(expected, actual, 1);
    }
}
