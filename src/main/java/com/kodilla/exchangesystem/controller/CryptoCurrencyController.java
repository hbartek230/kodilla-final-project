package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import com.kodilla.exchangesystem.exception.CryptoCurrencyNotFoundException;
import com.kodilla.exchangesystem.mapper.CryptoCurrencyMapper;
import com.kodilla.exchangesystem.repository.CryptoCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/crypto")
public class CryptoCurrencyController {

    private final CryptoCurrencyRepository repository;
    private final CryptoCurrencyMapper mapper;

    @Autowired
    public CryptoCurrencyController(CryptoCurrencyRepository repository, CryptoCurrencyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CryptoCurrencyDto> getCryptoCurrencies() {
        return mapper.mapToCryptoCurrencyDtoList(repository.findAll());
    }

    @GetMapping(params = "cryptoCurrencyId")
    public CryptoCurrencyDto getCryptoCurrency(@RequestParam Long cryptoCurrencyId)
            throws CryptoCurrencyNotFoundException {
        return mapper.mapToCryptoCurrencyDto(repository.findById(cryptoCurrencyId)
                .orElseThrow(CryptoCurrencyNotFoundException::new));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CryptoCurrencyDto addCryptoCurrency(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        return mapper.mapToCryptoCurrencyDto(repository.save(mapper.mapToCryptoCurrency(cryptoCurrencyDto)));
    }

    @PutMapping
    public CryptoCurrencyDto updateCryptoCurrency(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        return mapper.mapToCryptoCurrencyDto(repository.save(mapper.mapToCryptoCurrency(cryptoCurrencyDto)));
    }

    @DeleteMapping
    public void deleteCryptoCurrency(@RequestParam Long cryptoCurrencyId) {
        repository.deleteById(cryptoCurrencyId);
    }
}
