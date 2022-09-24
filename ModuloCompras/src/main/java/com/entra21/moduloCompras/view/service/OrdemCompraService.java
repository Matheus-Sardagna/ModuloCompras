package com.entra21.moduloCompras.view.service;



import com.entra21.moduloCompras.model.dto.OrdemCompraDTO;
import com.entra21.moduloCompras.model.entity.OrdemCompraEntity;
import com.entra21.moduloCompras.view.repository.OrdemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdemCompraService {
    @Autowired
    private OrdemCompraRepository ordemCompraRepository;

    public List<OrdemCompraDTO> getAll() {
        return ordemCompraRepository.findAll().stream().map(o -> {
            OrdemCompraDTO dto = new OrdemCompraDTO();
            dto.setId(o.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    //É necessário um save nesse?
    public void save(OrdemCompraDTO input) {
        OrdemCompraEntity newEntity = new OrdemCompraEntity();
        ordemCompraRepository.save(newEntity);
    }

    public OrdemCompraDTO getById(Long id) {
        OrdemCompraEntity o = ordemCompraRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de compra não encontrada."));
        OrdemCompraDTO dto = new OrdemCompraDTO();
        dto.setId(o.getId());
        return dto;
    }

    public void delete(Long id) {
        ordemCompraRepository.deleteById(id);
    }

    //É necessário um update nesse?
    public OrdemCompraDTO update(Long id, OrdemCompraEntity ordemCompraItemEntity) {
        OrdemCompraEntity o = ordemCompraRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de compra não encontrada."));
        o = ordemCompraRepository.save(o);
        OrdemCompraDTO dto = new OrdemCompraDTO();
        dto.setId(o.getId());
        return dto;
    }

    public OrdemCompraEntity read(Long id, OrdemCompraEntity ordemCompraItemEntity){
        return ordemCompraRepository.findById(id).orElseThrow(() -> new RuntimeException("Ordem de compra não encontrada."));
    }
}