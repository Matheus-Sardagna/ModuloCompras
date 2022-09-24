package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.EmpresaDTO;
import com.entra21.moduloCompras.model.entity.EmpresaEntity;
import com.entra21.moduloCompras.view.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaRestController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<EmpresaDTO> getEmpresa(){
        return empresaService.getAll();
    }

    @PostMapping
    public void addEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        empresaService.save(empresaDTO);
    }

    @GetMapping("/{id}")
    public EmpresaDTO getEmpresa(@PathVariable(name = "id") Long id) {
        return empresaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable(name = "id") Long id) {
        empresaService.delete(id);
    }

    @PutMapping("/{id}")
    public EmpresaDTO updateEmpresa(@PathVariable(name = "id") Long id,
                                    @RequestBody EmpresaEntity novaRazaoSocial) {
        return empresaService.update(id, novaRazaoSocial);
    }

}
