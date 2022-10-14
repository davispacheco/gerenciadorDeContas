package com.modulo5.backEnd.service;

import com.modulo5.backEnd.DTO.EstadoRespostaDTO;
import com.modulo5.backEnd.model.EstadoModel;
import com.modulo5.backEnd.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoRespostaDTO> buscarTodos() {
        List<EstadoModel> estados = estadoRepository.findAll();
        return EstadoRespostaDTO.converterLista(estados);
    }

    public EstadoModel buscarPorId(Long codigo) {
        Optional<EstadoModel> obj = estadoRepository.findById(codigo);
        return obj.get();
    }

    public EstadoModel cadastrar(EstadoModel estadoModel) {
        return estadoRepository.save(estadoModel);
    }

    public EstadoModel alterar(EstadoModel estadoModel, Long codigo) {
        EstadoModel newEstado = buscarPorId(codigo);
        newEstado.setNomeEstado(estadoModel.getNomeEstado());
        newEstado.setUf(estadoModel.getUf());
        return estadoRepository.save(newEstado);
    }

    public void deletar(Long codigo) {
        estadoRepository.deleteById(codigo);
    }
}
