package com.modulo5.backEnd.factory;

import java.math.BigDecimal;

public class CalculoAlugueisEmDia implements CalculoAlugueis {
    @Override
    public BigDecimal calcular(BigDecimal valorAReceber) {
        return valorAReceber;
    }
}
