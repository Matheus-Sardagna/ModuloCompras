package com.entra21.moduloCompras.model.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private Boolean ativo;
}
