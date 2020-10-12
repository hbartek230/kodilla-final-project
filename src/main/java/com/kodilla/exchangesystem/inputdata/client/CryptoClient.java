package com.kodilla.exchangesystem.inputdata.client;

import com.kodilla.exchangesystem.inputdata.config.CryptoCurrencyConfig;
import com.kodilla.exchangesystem.inputdata.domain.dto.InnerCryptoCurrencyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
public class CryptoClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(CryptoClient.class);

    private final CryptoCurrencyConfig cryptoConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public CryptoClient(CryptoCurrencyConfig cryptoConfig, RestTemplate restTemplate) {
        this.cryptoConfig = cryptoConfig;
        this.restTemplate = restTemplate;
    }

    public InnerCryptoCurrencyDto getBitcoinValueData() {
        URI url = buildConnection();
        try {
            InnerCryptoCurrencyDto currencyResponse = restTemplate.getForObject(url, InnerCryptoCurrencyDto.class);
            return Optional.ofNullable(currencyResponse).orElse(new InnerCryptoCurrencyDto());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new InnerCryptoCurrencyDto();
        }
    }

    private URI buildConnection() {
        return UriComponentsBuilder.fromHttpUrl(cryptoConfig.getCryptoEndpoint()).build().encode().toUri();
    }
}
