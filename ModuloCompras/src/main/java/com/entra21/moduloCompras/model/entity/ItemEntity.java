package com.entra21.moduloCompras.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.util.Set;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "item")
public class ItemEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private Boolean ativo;


    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private PessoaEntity idEmpresa;


}
