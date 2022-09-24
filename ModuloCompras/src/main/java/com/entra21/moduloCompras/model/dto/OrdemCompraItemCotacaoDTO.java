package com.entra21.moduloCompras.model.dto;

import lombok.Data;

@Data
public class OrdemCompraItemCotacaoDTO {
    private Long id;
    private Double valor;
    private Integer escolhida;
}
