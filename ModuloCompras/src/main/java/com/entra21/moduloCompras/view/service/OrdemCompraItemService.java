package com.entra21.moduloCompras.view.service;

import com.entra21.moduloCompras.model.dto.OrdemCompraItemDTO;
import com.entra21.moduloCompras.model.entity.OrdemCompraItemEntity;
import com.entra21.moduloCompras.view.repository.OrdemCompraItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdemCompraItemService {
    @Autowired
    public static OrdemCompraItemRepository ordemCompraItemRepository;

    public List<OrdemCompraItemDTO> getAll() {
        return ordemCompraItemRepository.findAll().stream().map(o -> {
            OrdemCompraItemDTO dto = new OrdemCompraItemDTO();
            dto.setId(o.getId());
            dto.setQuantidade(o.getQuantidade());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(OrdemCompraItemDTO input) {
        OrdemCompraItemEntity newEntity = new OrdemCompraItemEntity();
        newEntity.setQuantidade(input.getQuantidade());
        ordemCompraItemRepository.save(newEntity);
    }

    public OrdemCompraItemDTO getById(Long id) {
        OrdemCompraItemEntity o = ordemCompraItemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de compra não encontrada."));
        OrdemCompraItemDTO dto = new OrdemCompraItemDTO();
        dto.setId(o.getId());
        dto.setQuantidade(o.getQuantidade());
        return dto;
    }

    public void delete(Long id) {
        ordemCompraItemRepository.deleteById(id);
    }

    public OrdemCompraItemDTO update(Long id, OrdemCompraItemEntity ordemCompraItemEntity) {
        OrdemCompraItemEntity o = ordemCompraItemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de compra não encontrada."));
        o.setQuantidade(ordemCompraItemEntity.getQuantidade());
        o = ordemCompraItemRepository.save(o);
        OrdemCompraItemDTO dto = new OrdemCompraItemDTO();
        dto.setQuantidade(o.getQuantidade());
        dto.setId(o.getId());
        return dto;
    }

    public OrdemCompraItemEntity read(Long id, OrdemCompraItemEntity ordemCompraItemEntity){
        return ordemCompraItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Ordem de compra não encontrada."));
    }
}
