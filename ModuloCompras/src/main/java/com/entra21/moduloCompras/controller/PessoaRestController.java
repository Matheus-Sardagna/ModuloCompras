package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.PessoaDTO;
import com.entra21.moduloCompras.model.entity.PessoaEntity;
import com.entra21.moduloCompras.view.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaRestController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> getPessoa(){
        return pessoaService.getAll();
    }

    @PostMapping
    public void addPessoa(@RequestBody PessoaDTO pessoaDTO) {
        pessoaService.save(pessoaDTO);
    }

    @GetMapping("/{id}")
    public PessoaDTO getPessoa(@PathVariable(name = "id") Long id) {
        return pessoaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable(name = "id") Long id) {
        pessoaService.delete(id);
    }

    @PutMapping("/{id}")
    public PessoaDTO updatePessoa(@PathVariable(name = "id") Long id,
                                    @RequestBody PessoaEntity novoNome) {
        return pessoaService.update(id, novoNome);
    }
}
