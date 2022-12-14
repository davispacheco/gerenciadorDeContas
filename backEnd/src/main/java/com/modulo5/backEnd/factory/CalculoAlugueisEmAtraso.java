package com.modulo5.backEnd.factory;

import java.math.BigDecimal;

public class CalculoAlugueisEmAtraso implements CalculoAlugueis {
    @Override
    public BigDecimal calcular(BigDecimal valorAReceber) {
        BigDecimal multa = valorAReceber.multiply(new BigDecimal("0.035"));
        BigDecimal resultado = valorAReceber.add(multa);
        return resultado;
    }
}
