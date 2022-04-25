package com.example.lab2.web;

import com.example.lab2.model.Author;
import com.example.lab2.model.dto.AuthorDto;
import com.example.lab2.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }

    @PostMapping("/addAuthor")
    public String saveAuthor(@RequestBody AuthorDto authorDto){
        this.authorService.save(authorDto);
        return "Author is saved...";
    }
}
