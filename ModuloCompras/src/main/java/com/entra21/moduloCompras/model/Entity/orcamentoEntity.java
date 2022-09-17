package com.entra21.moduloCompras.model.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orcamento")
public class orcamentoEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id")
    private empresaEntity idEmpresa;
}
