package com.kodilla.exchangesystem.inputdata.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class NBPConfig {

    @Value("${nbp.api.endpoint.prod}")
    private String nbpEndpoint;

    @Value("${nbp.api.endpoint.date}")
    private String nbpEndpointDate;

    @Value(("${nbp.api.endpoint.format}"))
    private String nbpEndpointFormat;
}
