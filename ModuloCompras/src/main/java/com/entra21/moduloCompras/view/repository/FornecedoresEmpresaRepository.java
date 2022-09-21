package com.entra21.moduloCompras.view.repository;

import com.entra21.moduloCompras.model.entity.FornecedoresEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresEmpresaRepository extends JpaRepository<FornecedoresEmpresaEntity, Long> {
}