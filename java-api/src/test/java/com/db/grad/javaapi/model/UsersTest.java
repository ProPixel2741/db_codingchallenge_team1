package com.db.grad.javaapi.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UsersTest {
    @Test
    void testGetId() {
        Users u = new Users();
        u.setId(0);

        int expected = 0;
        int actual = u.getId();

        assertEquals(expected, actual);
    }

    @Test
    void testGetPassword() {
        Users u = new Users();
        u.setPassword("password");

        String expected = "password";
        String actual = u.getPassword();

        assertEquals(expected, actual);
    }

    @Test
    void testGetRole() {
        Users u = new Users();
        u.setRole("ADMIN");

        String expected = "ADMIN";
        String actual = u.getRole();

        assertEquals(expected, actual);
    }

    @Test
    void testGetUsername() {
        Users u = new Users();
        u.setUsername("username");

        String expected = "username";
        String actual = u.getUsername();

        assertEquals(expected, actual);
    }

    @Test
    void testGetOwnedBooks() {
        Users u = new Users();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        Set<Book> ownedBooks = new HashSet<>();
        ownedBooks.add(book1);
        ownedBooks.add(book2);
        ownedBooks.add(book3);

        u.setOwnedBooks(ownedBooks);

        assertEquals(u.getOwnedBooks().toString(), ownedBooks.toString());
    }
}
