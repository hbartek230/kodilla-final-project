package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import com.kodilla.exchangesystem.exception.CryptoCurrencyNotFoundException;
import com.kodilla.exchangesystem.mapper.CryptoCurrencyMapper;
import com.kodilla.exchangesystem.repository.CryptoCurrencyRepository;
import com.kodilla.exchangesystem.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/crypto")
public class CryptoCurrencyController {

    private final CryptoCurrencyService service;
    private final CryptoCurrencyMapper mapper;

    @Autowired
    public CryptoCurrencyController(CryptoCurrencyService service, CryptoCurrencyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CryptoCurrencyDto> getCryptoCurrencies() {
        return mapper.mapToCryptoCurrencyDtoList(service.getCryptoCurrencies());
    }

    @GetMapping(params = "cryptoCurrencyId")
    public CryptoCurrencyDto getCryptoCurrency(@RequestParam Long cryptoCurrencyId)
            throws CryptoCurrencyNotFoundException {
        return mapper.mapToCryptoCurrencyDto(service.getCryptoCurrency(cryptoCurrencyId));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CryptoCurrencyDto addCryptoCurrency(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        return mapper.mapToCryptoCurrencyDto(service.addCryptoCurrency(mapper.mapToCryptoCurrency(cryptoCurrencyDto)));
    }

    @PutMapping
    public CryptoCurrencyDto updateCryptoCurrency(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        return mapper.mapToCryptoCurrencyDto(service.addCryptoCurrency(mapper.mapToCryptoCurrency(cryptoCurrencyDto)));
    }

    @DeleteMapping
    public void deleteCryptoCurrency(@RequestParam Long cryptoCurrencyId) {
        service.deleteCryptoCurrency(cryptoCurrencyId);
    }
}
