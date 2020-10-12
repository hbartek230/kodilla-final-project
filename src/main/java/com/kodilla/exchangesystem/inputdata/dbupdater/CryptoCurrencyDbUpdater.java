package com.kodilla.exchangesystem.inputdata.dbupdater;

import com.kodilla.exchangesystem.controller.CryptoCurrencyController;
import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import com.kodilla.exchangesystem.inputdata.client.CryptoClient;
import com.kodilla.exchangesystem.inputdata.domain.dto.InnerCryptoCurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class CryptoCurrencyDbUpdater {

    private final CryptoClient cryptoClient;
    private final CryptoCurrencyController controller;

    @Autowired
    public CryptoCurrencyDbUpdater(CryptoClient client, CryptoCurrencyController controller) {
        this.cryptoClient = client;
        this.controller = controller;
    }

    public void addCryptoCurrencyToDatabase() {
        InnerCryptoCurrencyDto cryptoCurrency = cryptoClient.getBitcoinValueData();
        controller.addCryptoCurrency(new CryptoCurrencyDto(
                "Bitcoin",
                Double.parseDouble(cryptoCurrency.getBitcoinValue())));
    }
}
