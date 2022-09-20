package com.entra21.moduloCompras.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ordem_compra_item_cotacao")
public class OrdemCompraItemCotacaoEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "escolhida")
    private Integer escolhida;

    @ManyToOne
    @JoinColumn(name = "id_ordem_compra_item", referencedColumnName = "id")
    private OrdemCompraItemEntity idOrdemCompraItem;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id")
    private EmpresaEntity idFornecedor;

}

