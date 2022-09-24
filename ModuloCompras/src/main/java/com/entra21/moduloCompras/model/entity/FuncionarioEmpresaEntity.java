package com.entra21.moduloCompras.model.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "funcionario_empresa")

public class FuncionarioEmpresaEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private EmpresaEntity idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private PessoaEntity idPessoa;

    @Column(name = "ativo")
    private Boolean ativo;
}
