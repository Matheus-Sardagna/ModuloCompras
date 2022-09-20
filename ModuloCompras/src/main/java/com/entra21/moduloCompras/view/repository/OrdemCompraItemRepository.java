package com.entra21.moduloCompras.view.repository;

import com.entra21.moduloCompras.model.entity.OrdemCompraEntity;
import com.entra21.moduloCompras.model.entity.OrdemCompraItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemCompraItemRepository extends JpaRepository<OrdemCompraItemEntity, Long> {
}
