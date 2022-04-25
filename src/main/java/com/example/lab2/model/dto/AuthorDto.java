package com.example.lab2.model.dto;

import lombok.Data;

@Data
public class AuthorDto {
    String name;
    String surname;
    Long country;

    public AuthorDto(String name, String surname, Long country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
