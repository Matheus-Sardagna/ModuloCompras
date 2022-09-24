package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.FornecedoresEmpresaDTO;
import com.entra21.moduloCompras.model.entity.FornecedoresEmpresaEntity;
import com.entra21.moduloCompras.view.service.FornecedoresEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fornecedoresempresa")

public class FornecedoresEmpresaRestController {
    @Autowired
    private FornecedoresEmpresaService fornecedoresEmpresaService;

    @GetMapping
    public List<FornecedoresEmpresaDTO> getFornecedoresEmpresa() {
        return fornecedoresEmpresaService.getAll();
    }

    @PostMapping
    public void addFornecedoresEmpresa(@RequestBody FornecedoresEmpresaDTO fornecedoresEmpresaDTO) {
        fornecedoresEmpresaService.save(fornecedoresEmpresaDTO);
    }

    @GetMapping("/{id}")
    public FornecedoresEmpresaDTO getFornecedoresEmpresa(@PathVariable(name = "id") Long id) {
        return fornecedoresEmpresaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFornecedoresEmpresa(@PathVariable(name = "id") Long id) {
        fornecedoresEmpresaService.delete(id);
    }

    @PutMapping("/{id}")
    public FornecedoresEmpresaDTO updateFornecedoresEmpresa(@PathVariable(name = "id") Long id,
                                        @RequestBody FornecedoresEmpresaEntity novoFornecedoresEmpresa) {
        return fornecedoresEmpresaService.update(id, novoFornecedoresEmpresa);
    }
}