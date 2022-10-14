package com.modulo5.backEnd.repository;

import com.modulo5.backEnd.model.ContasAPagarModel;
import com.modulo5.backEnd.enumeration.Status;
import com.modulo5.backEnd.enumeration.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {
    List<ContasAPagarModel> findByNome(String nome);

    List<ContasAPagarModel> findByStatus(Status status);

    List<ContasAPagarModel> findByTipo(Tipo tipo);
}
