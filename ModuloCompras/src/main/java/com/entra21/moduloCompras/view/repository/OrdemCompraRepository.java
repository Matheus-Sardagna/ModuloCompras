package com.entra21.moduloCompras.view.repository;

import com.entra21.moduloCompras.model.entity.OrdemCompraEntity;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemCompraRepository extends JpaRepository<OrdemCompraEntity, Long> {
}
