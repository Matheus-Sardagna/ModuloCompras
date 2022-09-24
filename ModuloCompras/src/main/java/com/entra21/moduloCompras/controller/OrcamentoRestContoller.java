package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.OrcamentoDTO;
import com.entra21.moduloCompras.model.entity.OrcamentoEntity;
import com.entra21.moduloCompras.view.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoRestContoller {
    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping
    public List<OrcamentoDTO> getOrcamento(){
        return orcamentoService.getAll();
    }

    @PostMapping
    public void addOrcamento(@RequestBody OrcamentoDTO orcamentoDTO) {
        orcamentoService.save(orcamentoDTO);
    }

    @GetMapping("/{id}")
    public OrcamentoDTO getOrcamento(@PathVariable(name = "id") Long id) {
        return orcamentoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrcamento(@PathVariable(name = "id") Long id) {
        orcamentoService.delete(id);
    }

    @PutMapping("/{id}")
    public OrcamentoDTO updateOrcamento(@PathVariable(name = "id") Long id,
                                  @RequestBody OrcamentoEntity novoOrcamento) {
        return orcamentoService.update(id, novoOrcamento);
    }
}
