package com.entra21.moduloCompras.controller;


import com.entra21.moduloCompras.model.dto.OrdemCompraItemDTO;
import com.entra21.moduloCompras.model.entity.OrdemCompraItemEntity;
import com.entra21.moduloCompras.view.service.OrdemCompraItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordemcompraitem")
public class OrdemCompraItemRestController {

    @Autowired
    private OrdemCompraItemService ordemCompraItemService;

    @GetMapping
    public List<OrdemCompraItemDTO> getOrdemCompraItem(){
        return ordemCompraItemService.getAll();
    }

    @PostMapping
    public void addOrdemCompraItem(@RequestBody OrdemCompraItemDTO ordemCompraItemDTO) {
        ordemCompraItemService.save(ordemCompraItemDTO);
    }

    @GetMapping("/{id}")
    public OrdemCompraItemDTO getOrdemCompraItem(@PathVariable(name = "id") Long id) {
        return ordemCompraItemService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdemCompraItem(@PathVariable(name = "id") Long id) {
        ordemCompraItemService.delete(id);
    }

    @PutMapping("/{id}")
    public OrdemCompraItemDTO updateEmpresa(@PathVariable(name = "id") Long id,
                                    @RequestBody OrdemCompraItemEntity novaOrdemCompraItem) {
        return ordemCompraItemService.update(id, novaOrdemCompraItem);
    }
}

