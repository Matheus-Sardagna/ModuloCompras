package com.entra21.moduloCompras.view.repository;

import com.entra21.moduloCompras.model.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

    public PessoaEntity findByLogin(String login);
}
