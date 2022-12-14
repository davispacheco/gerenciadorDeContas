package com.modulo5.backEnd.DTO;

import com.modulo5.backEnd.enums.Status;
import com.modulo5.backEnd.enums.Tipo;
import com.modulo5.backEnd.model.ContasAPagarModel;
import com.modulo5.backEnd.model.UsuarioModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ContasAPagarDTO {
    @NotBlank(message = "Nome da conta deve ser preenchido.")
    private String nome;

    @Min(value = 1, message = "Valor da conta deve ser preenchido.")
    private double valor;

    @NotNull(message = "Tipo da conta deve ser preenchido.")
    private Tipo tipo;

    @NotNull(message = "Data de vencimento deve ser preenchida.")
    private LocalDate dataDeVencimento;

    private LocalDateTime dataDePagamento;

    private Status status;

    private UsuarioModel usuario;

    public ContasAPagarModel converterParaObjeto() {
        return new ContasAPagarModel(nome, valor, tipo, dataDeVencimento, dataDePagamento, status, usuario);
    }
}
