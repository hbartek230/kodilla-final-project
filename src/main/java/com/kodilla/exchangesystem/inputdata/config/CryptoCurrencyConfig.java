package com.kodilla.exchangesystem.inputdata.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CryptoCurrencyConfig {

    @Value("${crypto.api.endpoint.prod}")
    private String cryptoEndpoint;
}
