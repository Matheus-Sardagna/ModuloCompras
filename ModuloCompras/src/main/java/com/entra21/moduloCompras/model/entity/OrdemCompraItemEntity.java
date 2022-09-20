package com.entra21.moduloCompras.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ordem_compra_item")
public class OrdemCompraItemEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_ordem_compra", referencedColumnName = "id")
    private OrdemCompraEntity idOrdemCompra;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private ItemEntity idItem;
}
