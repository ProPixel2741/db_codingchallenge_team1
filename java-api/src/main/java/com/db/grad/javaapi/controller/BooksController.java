package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
public class BooksController {

    @Autowired
    private BooksService booksService;
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return booksService.getBookById(id);
    }
}
