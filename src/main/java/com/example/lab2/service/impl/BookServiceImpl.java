package com.example.lab2.service.impl;

import com.example.lab2.model.Author;
import com.example.lab2.model.Book;
import com.example.lab2.model.Category;
import com.example.lab2.model.dto.BookDto;
import com.example.lab2.repository.jpa.AuthorRepository;
import com.example.lab2.repository.jpa.BookRepository;
import com.example.lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Category category = Category.valueOf(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElse(null);
        Book book = new Book(bookDto.getName(),category,author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(null);

        book.setName(bookDto.getName());
        book.setCategory(Category.valueOf(bookDto.getCategory()));
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(null);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(null);
        this.bookRepository.delete(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(null);
        Integer copies = book.getAvailableCopies()-1;
        book.setAvailableCopies(copies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
