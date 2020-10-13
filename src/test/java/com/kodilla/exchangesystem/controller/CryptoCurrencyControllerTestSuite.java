package com.kodilla.exchangesystem.controller;

import com.google.gson.Gson;
import com.kodilla.exchangesystem.domain.CryptoCurrency;
import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import com.kodilla.exchangesystem.mapper.CryptoCurrencyMapper;
import com.kodilla.exchangesystem.service.CryptoCurrencyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CryptoCurrencyControllerTestSuite {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private CryptoCurrencyMapper mapper;

    @MockBean
    private CryptoCurrencyService service;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void shouldReturnEmptyCryptoCurrencyList() throws Exception {
        // given
        List<CryptoCurrencyDto> cryptoDtoList = new ArrayList<>();
        List<CryptoCurrency> cryptoList = new ArrayList<>();
        when(mapper.mapToCryptoCurrencyDtoList(new ArrayList<>())).thenReturn(cryptoDtoList);
        when(service.getCryptoCurrencies()).thenReturn(cryptoList);

        // when & then
        mockMvc.perform(get("/crypto")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void should_returnCryptoCurrencyList() throws Exception {
        // given
        List<CryptoCurrencyDto> cryptoDtoList = Collections.singletonList(new CryptoCurrencyDto(1L, "BTC", 1.0));
        List<CryptoCurrency> cryptoList = Collections.singletonList(new CryptoCurrency(1L, "BTC", 1.0));
        when(mapper.mapToCryptoCurrencyDtoList(new ArrayList<>())).thenReturn(cryptoDtoList);
        when(service.getCryptoCurrencies()).thenReturn(cryptoList);

        // when & then
        mockMvc.perform(get("/crypto")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].currencyName", is("BTC")))
                .andExpect(jsonPath("$[0].currencyValue", is(1.0)));
    }

    @Test
    public void should_returnSingleCryptoCurrency() throws Exception {
        // given
        CryptoCurrencyDto cryptoCurrencyDto = new CryptoCurrencyDto(1L, "BTC", 1.0);
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1L, "BTC", 1.0);
        when(mapper.mapToCryptoCurrencyDto(ArgumentMatchers.any(CryptoCurrency.class))).thenReturn(cryptoCurrencyDto);
        when(service.getCryptoCurrency(1L)).thenReturn(cryptoCurrency);

        // when & then
        mockMvc.perform(get("/crypto")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .param("cryptoCurrencyId", "1"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.currencyName", is("BTC")));
    }

    @Test
    public void should_removeCryptoCurrency() throws Exception {
        // given
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1L, "BTC", 1.0);
        when(service.getCryptoCurrency(1L)).thenReturn(cryptoCurrency);

        // when & then
        mockMvc.perform(delete("/crypto")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .param("cryptoCurrencyId", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_addNewCryptoCurrency() throws Exception {
        // given
        CryptoCurrencyDto cryptoDto = new CryptoCurrencyDto(1L, "BTC", 1.0);
        CryptoCurrency crypto = new CryptoCurrency(1L, "BTC", 1.0);
        when(mapper.mapToCryptoCurrency(ArgumentMatchers.any(CryptoCurrencyDto.class))).thenReturn(crypto);
        when(mapper.mapToCryptoCurrencyDto(ArgumentMatchers.any(CryptoCurrency.class))).thenReturn(cryptoDto);
        when(service.addCryptoCurrency(ArgumentMatchers.any(CryptoCurrency.class))).thenReturn(crypto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(cryptoDto);

        // when & then
        mockMvc.perform(post("/crypto")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(jsonContent))
                .andExpect(status().isOk());
    }
}
