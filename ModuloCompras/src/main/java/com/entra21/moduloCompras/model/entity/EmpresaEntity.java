package com.entra21.moduloCompras.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empresa")
public class EmpresaEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social")
    private String razao_social;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "fornecedor")
    private Boolean fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_gerente", referencedColumnName = "id")
    private PessoaEntity idGerente;

}
