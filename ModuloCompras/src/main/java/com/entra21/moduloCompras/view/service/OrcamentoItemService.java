package com.entra21.moduloCompras.view.service;

import com.entra21.moduloCompras.model.dto.OrcamentoItemDTO;
import com.entra21.moduloCompras.model.entity.OrcamentoItemEntity;
import com.entra21.moduloCompras.view.repository.OrcamentoItemRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrcamentoItemService {

    @Autowired
    public static OrcamentoItemRespository orcamentoItemRespository;

    public List<OrcamentoItemDTO> getAll() {
        return orcamentoItemRespository.findAll().stream().map(o -> {
            OrcamentoItemDTO dto = new OrcamentoItemDTO();
            dto.setId(o.getId());
            dto.setValorMaximo(o.getValorMaximo());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(OrcamentoItemDTO input) {
        OrcamentoItemEntity newEntity = new OrcamentoItemEntity();
        newEntity.setValorMaximo(input.getValorMaximo());
        orcamentoItemRespository.save(newEntity);
    }

    public OrcamentoItemDTO getById(Long id) {
        OrcamentoItemEntity o = orcamentoItemRespository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orçamento não encontrado."));
        OrcamentoItemDTO dto = new OrcamentoItemDTO();
        dto.setId(o.getId());
        dto.setValorMaximo(o.getValorMaximo());
        return dto;
    }

    public void delete(Long id) {
        orcamentoItemRespository.deleteById(id);
    }

    public OrcamentoItemDTO update(Long id, OrcamentoItemEntity orcamentoItemEntity) {
        OrcamentoItemEntity o = orcamentoItemRespository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orçamento não encontrado."));
        o.setValorMaximo(orcamentoItemEntity.getValorMaximo());
        o = orcamentoItemRespository.save(o);
        OrcamentoItemDTO dto = new OrcamentoItemDTO();
        dto.setValorMaximo(o.getValorMaximo());
        dto.setId(o.getId());
        return dto;
    }

    public OrcamentoItemEntity read(Long id, OrcamentoItemEntity orcamentoItemEntity){
        return orcamentoItemRespository.findById(id).orElseThrow(() -> new RuntimeException("Orçamento não encontrado."));
    }
}
