package com.entra21.moduloCompras.model.dto;


import lombok.Data;

@Data
public class CotacaoFornecedorDTO {

    private Long idfornecedor;

    private Long idOrtdemCompraItem;

    private String descricao;

    private Double quantidade;

    private Double valorUnitario;

    private Double valorTotal;

}
