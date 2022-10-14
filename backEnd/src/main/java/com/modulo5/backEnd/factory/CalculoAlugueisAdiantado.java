package com.modulo5.backEnd.factory;

import java.math.BigDecimal;

public class CalculoAlugueisAdiantado implements CalculoAlugueis {
    @Override
    public BigDecimal calcular(BigDecimal valorAReceber) {
        BigDecimal desconto = valorAReceber.multiply(new BigDecimal("0.05"));
        BigDecimal resultado = valorAReceber.add(desconto);
        return resultado;
    }
}
