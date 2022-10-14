package com.modulo5.backEnd.service;

import com.modulo5.backEnd.DTO.EnderecoRespostaDTO;
import com.modulo5.backEnd.model.EnderecoModel;
import com.modulo5.backEnd.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoRespostaDTO> buscarTodos() {
        List<EnderecoModel> enderecos = enderecoRepository.findAll();
        return EnderecoRespostaDTO.converterLista(enderecos);
    }

    public Optional<EnderecoModel> buscarPorId(Long codigo) {
        return enderecoRepository.findById(codigo);
    }

    public EnderecoModel cadastrar(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }

    public EnderecoModel alterar(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }

    public void deletar(Long codigo) {
        enderecoRepository.deleteById(codigo);
    }
}
