package com.entra21.moduloCompras.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orcamento_item")
public class OrcamentoItemEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_maximo")
    private Double valorMarximo;

    @ManyToOne
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id")
    private OrcamentoEntity idOrcamento;
}
