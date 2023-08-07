package com.db.grad.javaapi.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    void testGetId() {
        Book b1 = new Book();
        b1.setId(0);

        float expected = 0;
        float actual = b1.getId();

        assertEquals(expected, actual, 1);
    }

    @Test
    void testGetName() {
        Book b1 = new Book();
        b1.setName("Samantha");

        String expected = "Samantha";
        String actual = b1.getName();

        assertEquals(expected, actual);
    }
}
