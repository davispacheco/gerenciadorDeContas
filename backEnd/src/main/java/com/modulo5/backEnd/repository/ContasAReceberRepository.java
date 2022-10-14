package com.modulo5.backEnd.repository;

import com.modulo5.backEnd.enumeration.TipoRecebido;
import com.modulo5.backEnd.model.ContasAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceberModel, Long> {
    List<ContasAReceberModel> findByStatus(String status);

    List<ContasAReceberModel> findByTipoRecebido(TipoRecebido tipoRecebido);

    List<ContasAReceberModel> findByDataDeVencimento(LocalDate dataDeVencimento);
}
