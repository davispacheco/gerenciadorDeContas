package com.modulo5.backEnd.enums;

public enum Status {
    AGUARDANDO,
    PAGO,
    VENCIDA;

    public Status getAguardando() {
        return AGUARDANDO;
    }

    public Status getPago() {
        return PAGO;
    }

    public Status getVencida() {
        return VENCIDA;
    }
}
