package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.ItemDTO;
import com.entra21.moduloCompras.model.dto.OrcamentoItemDTO;
import com.entra21.moduloCompras.model.entity.ItemEntity;
import com.entra21.moduloCompras.model.entity.OrcamentoItemEntity;
import com.entra21.moduloCompras.view.service.ItemService;
import com.entra21.moduloCompras.view.service.OrcamentoItemService;
import com.entra21.moduloCompras.view.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/orcamento_item")
public class OrcamentoItemRestController {
    @Autowired
    private OrcamentoItemService orcamentoItemService;

    @GetMapping
    public List<OrcamentoItemDTO> getOrcamentoItem(){
        return orcamentoItemService.getAll();
    }

    @PostMapping
    public void addOrcamentoItem(@RequestBody OrcamentoItemDTO orcamentoItemDTO) {
        orcamentoItemService.save(orcamentoItemDTO);
    }

    @GetMapping("/{id}")
    public OrcamentoItemDTO getOrcamentoItem(@PathVariable(name = "id") Long id) {
        return orcamentoItemService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrcamentoItem(@PathVariable(name = "id") Long id) {
        orcamentoItemService.delete(id);
    }

    @PutMapping("/{id}")
    public OrcamentoItemDTO updateOrcamentoItem(@PathVariable(name = "id") Long id,
                              @RequestBody OrcamentoItemEntity orcamentoItemNovo) {
        return orcamentoItemService.update(id, orcamentoItemNovo);
    }
}
