package com.modulo5.backEnd.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class CalculoAlugueisEmAtrasoTest {
    @Mock
    CalculoAlugueisEmAtraso calculoAlugueisEmAtraso;

    @BeforeEach
    private void inicializacao() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testeValorFinal() {
        BigDecimal valorAReceber = new BigDecimal("50");
        BigDecimal resultado = calculoAlugueisEmAtraso.calcular(valorAReceber);
        Assertions.assertEquals("51.75", resultado);
    }
}
