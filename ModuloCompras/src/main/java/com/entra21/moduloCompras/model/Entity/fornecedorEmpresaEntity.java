package com.entra21.moduloCompras.model.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.util.List;

@Data
@Entity
@Table(name = "fornecedores_empresa")

public class fornecedorEmpresaEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ativo")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private empresaEntity idEmpresa;

    @ManyToMany
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id")
    private List<empresaEntity> idFornecedor;
}
