package com.entra21.moduloCompras.model.dto;

import lombok.Data;

@Data
public class EmpresaDTO {
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private Boolean fornecedor;
}
