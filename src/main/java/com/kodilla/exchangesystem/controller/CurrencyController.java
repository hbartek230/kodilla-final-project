package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import com.kodilla.exchangesystem.exception.CurrencyNotFoundException;
import com.kodilla.exchangesystem.exception.CurrencyRateNotFoundException;
import com.kodilla.exchangesystem.mapper.CurrencyMapper;
import com.kodilla.exchangesystem.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService service;
    private final CurrencyMapper mapper;

    @Autowired
    public CurrencyController(CurrencyService service, CurrencyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CurrencyDto> getCurrencies() {
        return mapper.mapToCurrencyDtoList(service.getCurrencies());
    }

    @GetMapping(params = "currencyId")
    public CurrencyDto getCurrency(@RequestParam Long currencyId) throws CurrencyNotFoundException {
        return mapper.mapToCurrencyDto(service.getSingleCurrency(currencyId));
    }

    @GetMapping(params = "currencyCode")
    public CurrencyDto getCurrencyByCode(@RequestParam String currencyCode) throws CurrencyNotFoundException {
        return mapper.mapToCurrencyDto(service.getCurrencyByCode(currencyCode));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CurrencyDto addCurrency(@RequestBody CurrencyDto currencyDto) throws CurrencyRateNotFoundException {
        return mapper.mapToCurrencyDto(service.addCurrency(mapper.mapToCurrency(currencyDto)));
    }

    @PutMapping
    public CurrencyDto updateCurrency(@RequestBody CurrencyDto currencyDto) throws CurrencyRateNotFoundException {
        return mapper.mapToCurrencyDto(service.addCurrency(mapper.mapToCurrency(currencyDto)));
    }

    @DeleteMapping
    public void deleteCurrency(@RequestParam Long currencyId) {
        service.deleteCurrency(currencyId);
    }
}
