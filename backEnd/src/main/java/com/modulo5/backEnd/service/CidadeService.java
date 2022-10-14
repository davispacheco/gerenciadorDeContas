package com.modulo5.backEnd.service;

import com.modulo5.backEnd.DTO.CidadeRespostaDTO;
import com.modulo5.backEnd.model.CidadeModel;
import com.modulo5.backEnd.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeRespostaDTO> buscarTodas() {
        List<CidadeModel> cidades = cidadeRepository.findAll();
        return CidadeRespostaDTO.converterLista(cidades);
    }

    public Optional<CidadeModel> buscarPorId(Long codigo) {
        return cidadeRepository.findById(codigo);
    }

    public CidadeModel cadastrar(CidadeModel cidadeModel) {
        return cidadeRepository.save(cidadeModel);
    }

    public CidadeModel alterar(CidadeModel cidadeModel) {
        return cidadeRepository.save(cidadeModel);
    }

    public void deletar(Long codigo) {
        cidadeRepository.deleteById(codigo);
    }
}
