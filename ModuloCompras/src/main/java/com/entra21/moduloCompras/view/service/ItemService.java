package com.entra21.moduloCompras.view.service;

import com.entra21.moduloCompras.model.dto.ItemDTO;
import com.entra21.moduloCompras.model.entity.ItemEntity;
import com.entra21.moduloCompras.view.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    public static ItemRepository itemRepository;

    public List<ItemDTO> getAll() {
        return itemRepository.findAll().stream().map(i -> {
            ItemDTO dto = new ItemDTO();
            dto.setId(i.getId());
            dto.setDescricao(i.getDescricao());
            dto.setAtivo(i.getAtivo());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(ItemDTO input) {
        ItemEntity newEntity = new ItemEntity();
        newEntity.setDescricao(input.getDescricao());
        newEntity.setAtivo(input.getAtivo());
        itemRepository.save(newEntity);
    }

    public ItemDTO getById(Long id) {
        ItemEntity i = itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
        ItemDTO dto = new ItemDTO();
        dto.setId(i.getId());
        dto.setDescricao(i.getDescricao());
        dto.setAtivo(i.getAtivo());
        return dto;
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public ItemDTO update(Long id, ItemEntity itemEntity) {
        ItemEntity i = itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
        i.setDescricao(itemEntity.getDescricao());
        i.setAtivo(itemEntity.getAtivo());
        i = itemRepository.save(i);
        ItemDTO dto = new ItemDTO();
        dto.setDescricao(i.getDescricao());
        dto.setAtivo(i.getAtivo());;
        dto.setId(i.getId());
        return dto;
    }

    public ItemEntity read(Long id, ItemEntity itemEntity){
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado."));
    }
}
