package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.Category;
import com.example.lab2.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, BookDto bookDto);
    Optional<Book> findById(Long id);
    Optional<Book> deleteById(Long id);
    Optional<Book> markAsTaken(Long id);
}
