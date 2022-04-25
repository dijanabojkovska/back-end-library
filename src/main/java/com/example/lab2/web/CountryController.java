package com.example.lab2.web;

import com.example.lab2.model.Country;
import com.example.lab2.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll(){
        return this.countryService.findAll();
    }

    @PostMapping("/addCountry")
    public String save(@RequestBody Country country){
        this.countryService.save(country);
        return "Country is saved...";
    }
}
