package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.OrdemCompraDTO;
import com.entra21.moduloCompras.model.entity.OrdemCompraEntity;
import com.entra21.moduloCompras.view.service.OrdemCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordemcompra")

public class OrdemCompraRestController {
    @Autowired
    private OrdemCompraService ordemCompraService;

    @GetMapping
    public List<OrdemCompraDTO> getOrdemCompra() {
        return ordemCompraService.getAll();
    }

    @PostMapping
    public void addOrdemCompra(@RequestBody OrdemCompraDTO ordemCompraDTO) {
        ordemCompraService.save(ordemCompraDTO);
    }

    @GetMapping("/{id}")
    public OrdemCompraDTO getOrdemCompra(@PathVariable(name = "id") Long id) {
        return ordemCompraService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdemCompra(@PathVariable(name = "id") Long id) {
        ordemCompraService.delete(id);
    }

    @PutMapping("/{id}")
    public OrdemCompraDTO updateOrdemCompra(@PathVariable(name = "id") Long id,
                                                            @RequestBody OrdemCompraEntity novaOrdemCompra) {
        return ordemCompraService.update(id, novaOrdemCompra);
    }
}