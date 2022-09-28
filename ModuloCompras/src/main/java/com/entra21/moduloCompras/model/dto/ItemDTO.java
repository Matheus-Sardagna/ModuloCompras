package com.entra21.moduloCompras.model.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String descricao;
    private Boolean ativo;
    private Long id_empresa;
}