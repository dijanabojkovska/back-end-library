package com.example.lab2.service;

import com.example.lab2.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> save(Country country);
}
