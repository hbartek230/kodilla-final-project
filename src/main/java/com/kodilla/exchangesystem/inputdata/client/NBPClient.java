package com.kodilla.exchangesystem.inputdata.client;

import com.kodilla.exchangesystem.inputdata.config.NBPConfig;
import com.kodilla.exchangesystem.inputdata.domain.dto.InnerCurrencyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NBPClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(NBPClient.class);

    private final NBPConfig config;
    private final RestTemplate restTemplate;
    private final List<String> currenciesCodeList;

    @Autowired
    public NBPClient(NBPConfig config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
        this.currenciesCodeList = Arrays.asList("usd", "eur", "chf", "gbp");
    }

    public List<InnerCurrencyDto> getCurrenciesFromNBP() {
        List<URI> uris = buildConnections();
        List<InnerCurrencyDto> currencies = new ArrayList<>();

        uris.forEach(uri -> {
            try {
                InnerCurrencyDto currencyResponse = restTemplate.getForObject(uri, InnerCurrencyDto.class);
                InnerCurrencyDto answer = Optional.ofNullable(currencyResponse).orElse(new InnerCurrencyDto());
                currencies.add(answer);
            } catch (RestClientException e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
        return currencies;
    }

    private List<URI> buildConnections() {
        return currenciesCodeList.stream()
                .map(currencyCode ->
                        UriComponentsBuilder.fromHttpUrl(config.getNbpEndpoint() + currencyCode + "/" +
                                config.getNbpEndpointDate())
                                .queryParam("format", config.getNbpEndpointFormat())
                                .build().encode().toUri())
                .collect(Collectors.toList());
    }
}
