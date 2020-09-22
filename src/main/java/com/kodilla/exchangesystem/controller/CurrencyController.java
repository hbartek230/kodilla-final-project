package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import com.kodilla.exchangesystem.exception.CurrencyNotFoundException;
import com.kodilla.exchangesystem.exception.CurrencyRateNotFoundException;
import com.kodilla.exchangesystem.mapper.CurrencyMapper;
import com.kodilla.exchangesystem.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyRepository repository;
    private final CurrencyMapper mapper;

    @Autowired
    public CurrencyController(CurrencyRepository repository, CurrencyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CurrencyDto> getCurrencies() {
        return mapper.mapToCurrencyDtoList(repository.findAll());
    }

    @GetMapping(params = "currencyId")
    public CurrencyDto getCurrency(@RequestParam Long currencyId) throws CurrencyNotFoundException {
        return mapper.mapToCurrencyDto(repository.findById(currencyId).orElseThrow(CurrencyNotFoundException::new));
    }

    @GetMapping(params = "currencyCode")
    public CurrencyDto getCurrencyByCode(@RequestParam String currencyCode) {
        return mapper.mapToCurrencyDto(repository.findByCurrencyCode(currencyCode));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CurrencyDto addCurrency(@RequestBody CurrencyDto currencyDto) throws CurrencyRateNotFoundException {
        return mapper.mapToCurrencyDto(repository.save(mapper.mapToCurrency(currencyDto)));
    }

    @PutMapping
    public CurrencyDto updateCurrency(@RequestBody CurrencyDto currencyDto) throws CurrencyRateNotFoundException {
        return mapper.mapToCurrencyDto(repository.save(mapper.mapToCurrency(currencyDto)));
    }

    @DeleteMapping
    public void deleteCurrency(@RequestParam Long currencyId) {
        repository.deleteById(currencyId);
    }
}
