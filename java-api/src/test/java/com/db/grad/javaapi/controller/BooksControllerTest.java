package com.db.grad.javaapi.controller;

import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BooksService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BooksControllerTest {

    @Autowired
    private BooksController booksController;

    @MockBean
    private BooksService booksService;

    @Test
    @DisplayName("Test getAllBooks")
    public void testGetAllBooks() {
        Book book1 = new Book();
        Book book2 = new Book();
        doReturn(Arrays.asList(book1, book2)).when(booksService).getAllBooks();
        
        List<Book> books = booksController.getAllBooks();

        Assertions.assertEquals(2, books.size());
    }

    @Test
    @DisplayName("Test getBookById")
    public void testGetBookById() {
        Book book = new Book();
        book.setId(1);
        doReturn(book).when(booksService).getBookById(1);

        Assertions.assertEquals(book, booksController.getBookById(1));
    }
}
