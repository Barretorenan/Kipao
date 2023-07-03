package com.example.echo.controller;

import com.example.echo.webservice.SwapiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class EchoControllerTest {

    @InjectMocks
    EchoController echoController;

    @Mock
    SwapiClient swapiClient;

    @Test
    void getEcho() {
        String retorno = echoController.getEcho("teste");

        Assertions.assertEquals("teste teste teste", retorno);
    }

    @Test
    void getPlanetName() {
        Mockito.when(swapiClient.getPlanetName("2")).thenReturn("teste");

        String retorno = echoController.getPlanetName("2");

        Assertions.assertEquals("Planeta Star Wars: teste", retorno);
    }
}
