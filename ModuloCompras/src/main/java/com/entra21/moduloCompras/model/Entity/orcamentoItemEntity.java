package com.entra21.moduloCompras.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orcamento_item")
public class orcamentoItemEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_maximo")
    private Double valorMarximo;

    @ManyToOne
    @JoinColumn(name = "id_orcamento", referencedColumnName = "id")
    private orcamentoEntity idOrcamento;
}
