package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/crypto")
public class CryptoCurrencyController {

    @GetMapping
    public List<CryptoCurrencyDto> getCryptoCurrencies() {
        return new ArrayList<>();
    }

    @GetMapping
    public CryptoCurrencyDto getCurrency(@RequestParam Long cryptoCurrencyId) {
        return new CryptoCurrencyDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CryptoCurrencyDto addCurrency(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        return new CryptoCurrencyDto();
    }

    @PutMapping
    public CryptoCurrencyDto updateCurrency(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        return new CryptoCurrencyDto();
    }

    @DeleteMapping
    public void deleteCurrency(@RequestParam Long cryptoCurrencyId) {

    }
}
