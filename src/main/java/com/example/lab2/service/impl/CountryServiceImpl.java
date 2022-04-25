package com.example.lab2.service.impl;

import com.example.lab2.model.Country;
import com.example.lab2.repository.jpa.CountryRepository;
import com.example.lab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(Country country) {
        this.countryRepository.save(country);
        return Optional.of(country);
    }

}
