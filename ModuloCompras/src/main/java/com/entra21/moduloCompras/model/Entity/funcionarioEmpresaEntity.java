package com.entra21.moduloCompras.model.Entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "funcionario_empresa")

public class funcionarioEmpresaEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private empresaEntity idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private empresaEntity idPessoa;
}
