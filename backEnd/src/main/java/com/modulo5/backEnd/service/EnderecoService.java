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

    public EnderecoModel buscarPorId(Long codigo) {
        Optional<EnderecoModel> obj = enderecoRepository.findById(codigo);
        return obj.get();
    }

    public EnderecoModel cadastrar(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }

    public EnderecoModel alterar(EnderecoModel enderecoModel, Long codigo) {
        EnderecoModel newEndereco = buscarPorId(codigo);
        newEndereco.setLogradouro(enderecoModel.getLogradouro());
        newEndereco.setBairro(enderecoModel.getBairro());
        return enderecoRepository.save(newEndereco);
    }

    public void deletar(Long codigo) {
        enderecoRepository.deleteById(codigo);
    }
}
