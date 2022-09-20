package com.entra21.moduloCompras.view.repository;

import com.entra21.moduloCompras.model.entity.OrcamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoEntity, Long> {
}
