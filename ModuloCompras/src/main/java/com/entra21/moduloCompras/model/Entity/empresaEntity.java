package com.entra21.moduloCompras.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "empresa")
public class empresaEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "fornecedor")
    private Boolean fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_gerente", referencedColumnName = "id")
    private pessoaEntity idGerente;

}
