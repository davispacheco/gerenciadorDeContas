package com.modulo5.backEnd.DTO;

import com.modulo5.backEnd.model.CidadeModel;
import com.modulo5.backEnd.model.EnderecoModel;
import com.modulo5.backEnd.model.UsuarioModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class EnderecoRespostaDTO {
    private Long codigo;
    private String logradouro;
    private String bairro;
    private String cep;
    private String pontoReferencia;
    private CidadeModel cidade;
    private UsuarioModel usuario;

    public static EnderecoRespostaDTO converterParaDTO(EnderecoModel endereco) {
        return new EnderecoRespostaDTO(endereco.getCodigo(), endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getPontoReferencia(), endereco.getCidade(), endereco.getUsuario());
    }

    public static List<EnderecoRespostaDTO> converterLista(List<EnderecoModel> enderecos) {
        List<EnderecoRespostaDTO> novaLista = new ArrayList<>();
        for (EnderecoModel endereco : enderecos) {
            EnderecoRespostaDTO novoEndereco = new EnderecoRespostaDTO(endereco.getCodigo(), endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getPontoReferencia(), endereco.getCidade(), endereco.getUsuario());
            novaLista.add(novoEndereco);
        }
        return novaLista;
    }
}
