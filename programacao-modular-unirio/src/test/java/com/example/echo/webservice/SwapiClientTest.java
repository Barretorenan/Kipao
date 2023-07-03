package com.example.echo.webservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class SwapiClientTest {
    @InjectMocks
    SwapiClient swapiClient;

    @Test
    void getPlanetName() {
        String retorno = swapiClient.getPlanetName("2");

        Assertions.assertEquals("Alderaan", retorno);
    }
}
