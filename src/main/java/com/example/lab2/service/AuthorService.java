package com.example.lab2.service;

import com.example.lab2.model.Author;
import com.example.lab2.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(AuthorDto authorDto);

}
