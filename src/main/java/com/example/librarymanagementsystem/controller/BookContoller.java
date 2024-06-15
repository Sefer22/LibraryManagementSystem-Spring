package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookContoller {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
        return bookService.save(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId,@PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId,userId);
        if(borrowedBook!=null) {
            return ResponseEntity.ok(borrowedBook);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if(returnedBook!=null) {
            return ResponseEntity.ok(returnedBook);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
