package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @GetMapping
    public List<CurrencyDto> getCurrencies() {
        return new ArrayList<>();
    }

    @GetMapping
    public CurrencyDto getCurrency(@RequestParam Long currencyId) {
        return new CurrencyDto();
    }

    @GetMapping
    public CurrencyDto getCurrencyByCode(@RequestParam String currencyCode) {
        return new CurrencyDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CurrencyDto addCurrency(@RequestBody CurrencyDto currencyDto) {
        return new CurrencyDto();
    }

    @PutMapping
    public CurrencyDto updateCurrency(@RequestBody CurrencyDto currencyDto) {
        return new CurrencyDto();
    }

    @DeleteMapping
    public void deleteCurrency(@RequestParam Long currencyId) {

    }
}
