package com.modulo5.backEnd.service;

import com.modulo5.backEnd.DTO.ContasAPagarRespostaDTO;
import com.modulo5.backEnd.model.ContasAPagarModel;
import com.modulo5.backEnd.enumeration.Status;
import com.modulo5.backEnd.enumeration.Tipo;
import com.modulo5.backEnd.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {
    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public List<ContasAPagarRespostaDTO> buscarTodas() {
        List<ContasAPagarModel> contas = contasAPagarRepository.findAll();
        return ContasAPagarRespostaDTO.converterLista(contas);
    }

    public ContasAPagarModel buscarPorId(Long id) {
        Optional<ContasAPagarModel> obj = contasAPagarRepository.findById(id);
        return obj.get();
    }

    public List<ContasAPagarModel> buscarPorNome(String nome) {
        return contasAPagarRepository.findByNome(nome);
    }

    public List<ContasAPagarModel> buscarPorStatus(Status status) {
        return contasAPagarRepository.findByStatus(status);
    }

    public List<ContasAPagarModel> buscarPorTipo(Tipo tipo) {
        return contasAPagarRepository.findByTipo(tipo);
    }

    public ContasAPagarModel cadastrar(ContasAPagarModel contasAPagarModel) {
        LocalDate dataAtual = LocalDate.now();
        if (contasAPagarModel.getDataDeVencimento().isBefore(dataAtual)) {
            contasAPagarModel.setStatus(Status.VENCIDA);
        } else {
            contasAPagarModel.setStatus(Status.AGUARDANDO);
        }
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alterar(ContasAPagarModel contasAPagarModel, Long id) {
        ContasAPagarModel newConta = buscarPorId(id);
        if (contasAPagarModel.getStatus().equals(Status.PAGO)) {
            LocalDateTime dataAtual = LocalDateTime.now();
            newConta.setDataDePagamento(dataAtual);
        }
        return contasAPagarRepository.save(newConta);
    }

    public void deletar(Long codigo) {
        contasAPagarRepository.deleteById(codigo);
    }
}
