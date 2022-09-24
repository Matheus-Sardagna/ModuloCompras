package com.entra21.moduloCompras.controller;

import com.entra21.moduloCompras.model.dto.ItemDTO;
import com.entra21.moduloCompras.model.dto.OrcamentoDTO;
import com.entra21.moduloCompras.model.entity.ItemEntity;
import com.entra21.moduloCompras.model.entity.OrcamentoEntity;
import com.entra21.moduloCompras.view.service.ItemService;
import com.entra21.moduloCompras.view.service.OrcamentoService;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemDTO> getItem(){
        return itemService.getAll();
    }

    @PostMapping
    public void addItem(@RequestBody ItemDTO itemDTO) {
        itemService.save(itemDTO);
    }

    @GetMapping("/{id}")
    public ItemDTO getItem(@PathVariable(name = "id") Long id) {
        return itemService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable(name = "id") Long id) {
        itemService.delete(id);
    }

    @PutMapping("/{id}")
    public ItemDTO updateItem(@PathVariable(name = "id") Long id,
                                        @RequestBody ItemEntity itemNovo) {
        return itemService.update(id, itemNovo);
    }
}
