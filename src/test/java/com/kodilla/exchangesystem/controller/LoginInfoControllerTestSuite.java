package com.kodilla.exchangesystem.controller;

import com.google.gson.Gson;
import com.kodilla.exchangesystem.domain.LoginInfo;
import com.kodilla.exchangesystem.domain.dto.LoginInfoDto;
import com.kodilla.exchangesystem.mapper.LoginInfoMapper;
import com.kodilla.exchangesystem.service.LoginInfoService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginInfoControllerTestSuite {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private LoginInfoService service;

    @MockBean
    private LoginInfoMapper mapper;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void should_returnEmptyLoginInfoList() throws Exception {
        // given
        List<LoginInfoDto> loginListDto = new ArrayList<>();
        List<LoginInfo> loginList = new ArrayList<>();
        when(mapper.mapToLoginInfoDtoList(new ArrayList<>())).thenReturn(loginListDto);
        when(service.getAllLoginInfos()).thenReturn(loginList);

        // when & then
        mockMvc.perform(get("/logininfo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void should_returnOneElementLoginInfoList() throws Exception {
        // given
        LocalDate dateToTests = LocalDate.now();
        List<LoginInfoDto> loginListDto = Collections.singletonList(new LoginInfoDto(1L, dateToTests, "login"));
        List<LoginInfo> loginList = Collections.singletonList(new LoginInfo(1L, dateToTests, "login"));
        when(mapper.mapToLoginInfoDtoList(new ArrayList<>())).thenReturn(loginListDto);
        when(service.getAllLoginInfos()).thenReturn(loginList);

        // when & then
        mockMvc.perform(get("/logininfo")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].timeStamp", is(dateToTests)))
                .andExpect(jsonPath("$[0].login", is("login")));
    }

    @Test
    public void should_returnOneLoginInfoWithSpecifiedLogin() throws Exception {
        //given
        LocalDate dateToTests = LocalDate.now();
        LoginInfoDto loginDto = new LoginInfoDto(1L, dateToTests, "login");
        LoginInfo login = new LoginInfo(1L, dateToTests, "login");
        when(mapper.mapToLoginInfoDtoList(new ArrayList<>())).thenReturn(Collections.singletonList(loginDto));
        when(service.getSingleUserLoginInfo("login")).thenReturn(Collections.singletonList(login));

        // when & then
        mockMvc.perform(get("/logininfo")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .param("login", "login"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.timeStamp", is(dateToTests)))
                .andExpect(jsonPath("$.login", is("login")));
    }

    @Test
    public void should_addNewLoginInfo() throws Exception {
        // given
        LocalDate dateToTests = LocalDate.now();
        LoginInfoDto loginDto = new LoginInfoDto(1L, dateToTests, "login");
        LoginInfo login = new LoginInfo(1L, dateToTests, "login");
        when(mapper.mapToLoginInfoDto(ArgumentMatchers.any(LoginInfo.class))).thenReturn(loginDto);
        when(mapper.mapToLoginInfo(ArgumentMatchers.any(LoginInfoDto.class))).thenReturn(login);
        when(service.addNewLoginInfo(ArgumentMatchers.any(LoginInfo.class))).thenReturn(login);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(loginDto);

        // when & then
        mockMvc.perform(post("/logininfo")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(jsonContent))
                .andExpect(status().is(200));
    }
}
