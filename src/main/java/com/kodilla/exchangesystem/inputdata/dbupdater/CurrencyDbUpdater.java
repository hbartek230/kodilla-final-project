package com.kodilla.exchangesystem.inputdata.dbupdater;

import com.kodilla.exchangesystem.controller.CurrencyController;
import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import com.kodilla.exchangesystem.domain.dto.CurrencyRateDto;
import com.kodilla.exchangesystem.exception.CurrencyRateNotFoundException;
import com.kodilla.exchangesystem.inputdata.client.NBPClient;
import com.kodilla.exchangesystem.inputdata.domain.dto.InnerCurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableAspectJAutoProxy
public class CurrencyDbUpdater {

    private final NBPClient nbpClient;
    private final CurrencyController currencyController;

    @Autowired
    public CurrencyDbUpdater(NBPClient client, CurrencyController controller) {
        this.nbpClient = client;
        this.currencyController = controller;
    }

    public void addCurrencyFromNBPToDatabase() {
        List<InnerCurrencyDto> currenciesToAdd = nbpClient.getCurrenciesFromNBP();
        currenciesToAdd.stream()
                .map(innerCurrencyDto ->
                        new CurrencyDto(
                                innerCurrencyDto.getCurrencyCode(),
                                innerCurrencyDto.getCurrencyName(),
                                new CurrencyRateDto(
                                        Double.parseDouble(innerCurrencyDto.getRate().get(0).getCurrencyBid()),
                                        Double.parseDouble(innerCurrencyDto.getRate().get(0).getCurrencyAsk()))))
                .forEach(currencyDto -> {
                    try {
                        currencyController.addCurrency(currencyDto);
                    } catch (CurrencyRateNotFoundException e) {
                        e.printStackTrace();
                    }
                });
    }
}
