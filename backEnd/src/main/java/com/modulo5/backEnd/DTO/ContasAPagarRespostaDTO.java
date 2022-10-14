package com.modulo5.backEnd.DTO;

import com.modulo5.backEnd.enumeration.Status;
import com.modulo5.backEnd.model.ContasAPagarModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ContasAPagarRespostaDTO {
    private Long codigo;
    private String nome;
    private double valor;
    private Status status;

    public static ContasAPagarRespostaDTO converterParaDTO(ContasAPagarModel contasAPagarModel) {
        return new ContasAPagarRespostaDTO(contasAPagarModel.getCodigo(), contasAPagarModel.getNome(), contasAPagarModel.getValor(), contasAPagarModel.getStatus());
    }

    public static List<ContasAPagarRespostaDTO> converterLista(List<ContasAPagarModel> contas) {
        List<ContasAPagarRespostaDTO> novaLista = new ArrayList<>();
        for (ContasAPagarModel conta : contas) {
            ContasAPagarRespostaDTO novaConta = new ContasAPagarRespostaDTO(conta.getCodigo(), conta.getNome(), conta.getValor(), conta.getStatus());
            novaLista.add(novaConta);
        }
        return novaLista;
    }
}
