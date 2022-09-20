package com.entra21.moduloCompras.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ordem_compra")
public class OrdemCompraEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private EmpresaEntity idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id")
    private OrcamentoEntity idOrcamento;
}
