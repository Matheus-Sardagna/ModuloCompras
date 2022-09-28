package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.OrdemCompraItemCotacaoDTO;
import com.entra21.moduloCompras.model.entity.OrdemCompraItemCotacaoEntity;
import com.entra21.moduloCompras.view.service.OrdemCompraItemCotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordem_compra_item_cotacao")
public class OrdemCompraItemCotacaoRestController {
    @Autowired
    private OrdemCompraItemCotacaoService ordemCompraItemCotacaoService;

    @GetMapping
    public List<OrdemCompraItemCotacaoDTO> getOrdemCompraItemCotacao(){
        return ordemCompraItemCotacaoService.getAll();
    }

    @PostMapping
    public void addOrdemCompraItemCotacao(@RequestBody OrdemCompraItemCotacaoDTO ordemCompraItemCotacaoDTO) {
        ordemCompraItemCotacaoService.save(ordemCompraItemCotacaoDTO);
    }

    @GetMapping("/{id}")
    public OrdemCompraItemCotacaoDTO getOrdemCompraItemCotacao(@PathVariable(name = "id") Long id) {
        return ordemCompraItemCotacaoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdemCompraItemCotacao(@PathVariable(name = "id") Long id) {
        ordemCompraItemCotacaoService.delete(id);
    }

    @PutMapping("/{id}")
    public OrdemCompraItemCotacaoEntity updateOrdemCompraItemCotacao(@PathVariable(name = "id") Long id,
                                                                     @RequestBody OrdemCompraItemCotacaoEntity novaOrdemCompraItemCotacao) {
        return ordemCompraItemCotacaoService.update(id, novaOrdemCompraItemCotacao);
    }
}
