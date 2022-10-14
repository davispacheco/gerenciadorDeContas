package com.modulo5.backEnd.repository;

import com.modulo5.backEnd.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
}
