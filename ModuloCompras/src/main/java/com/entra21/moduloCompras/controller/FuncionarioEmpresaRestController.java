package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.FuncionarioEmpresaDTO;
import com.entra21.moduloCompras.model.entity.FuncionarioEmpresaEntity;
import com.entra21.moduloCompras.view.service.FuncionarioEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionarioempresa")
public class FuncionarioEmpresaRestController {

    @Autowired
    private FuncionarioEmpresaService funcionarioEmpresaService;

    @GetMapping
    public List<FuncionarioEmpresaDTO> getFuncionarioEmpresa() {
        return funcionarioEmpresaService.getAll();
    }

    @PostMapping
    public void addFuncionarioEmpresa(@RequestBody FuncionarioEmpresaDTO funcionarioEmpresaDTO) {
        funcionarioEmpresaService.save(funcionarioEmpresaDTO);
    }

    @GetMapping("/{id}")
    public FuncionarioEmpresaDTO getFuncionarioEmpresa(@PathVariable(name = "id") Long id) {
        return funcionarioEmpresaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFuncionarioEmpresa(@PathVariable(name = "id") Long id) {
        funcionarioEmpresaService.delete(id);
    }

    @PutMapping("/{id}")
    public FuncionarioEmpresaDTO updateFuncionarioEmpresa(@PathVariable(name = "id") Long id,
                                                          @RequestBody FuncionarioEmpresaEntity novoFuncionarioEmpresa) {
        return funcionarioEmpresaService.update(id, novoFuncionarioEmpresa);
    }
}
