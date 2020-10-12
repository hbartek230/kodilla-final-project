package com.kodilla.exchangesystem.inputdata.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InnerCurrencyDto {

    @JsonProperty("currency")
    private String currencyName;

    @JsonProperty("code")
    private String currencyCode;

    @JsonProperty("rates")
    private List<InnerCurrencyRateDto> rate;
}
