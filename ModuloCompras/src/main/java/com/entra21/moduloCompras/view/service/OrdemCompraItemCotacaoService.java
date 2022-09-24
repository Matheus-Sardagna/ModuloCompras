package com.entra21.moduloCompras.view.service;


import com.entra21.moduloCompras.model.dto.OrdemCompraItemCotacaoDTO;
import com.entra21.moduloCompras.model.entity.OrdemCompraItemCotacaoEntity;
import com.entra21.moduloCompras.view.repository.OrdemCompraItemCotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdemCompraItemCotacaoService {

    @Autowired
    private OrdemCompraItemCotacaoRepository ordemCompraItemCotacaoRepository;

    public List<OrdemCompraItemCotacaoDTO> getAll() {
        return ordemCompraItemCotacaoRepository.findAll().stream().map(o -> {
            OrdemCompraItemCotacaoDTO dto = new OrdemCompraItemCotacaoDTO();
            dto.setId(o.getId());
            dto.setValor(o.getValor());
            dto.setEscolhida(o.getEscolhida());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(OrdemCompraItemCotacaoDTO input) {
        OrdemCompraItemCotacaoEntity newEntity = new OrdemCompraItemCotacaoEntity();
        newEntity.setValor(input.getValor());
        newEntity.setEscolhida(input.getEscolhida());
        ordemCompraItemCotacaoRepository.save(newEntity);
    }

    public OrdemCompraItemCotacaoDTO getById(Long id) {
        OrdemCompraItemCotacaoEntity o = ordemCompraItemCotacaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de compra não encontrada."));
        OrdemCompraItemCotacaoDTO dto = new OrdemCompraItemCotacaoDTO();
        dto.setId(o.getId());
        dto.setValor(o.getValor());
        dto.setEscolhida(o.getEscolhida());
        return dto;
    }

    public void delete(Long id) {
        ordemCompraItemCotacaoRepository.deleteById(id);
    }

    public OrdemCompraItemCotacaoDTO update(Long id, OrdemCompraItemCotacaoEntity ordemCompraItemCotacaoEntity) {
        OrdemCompraItemCotacaoEntity o = ordemCompraItemCotacaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de compra não encontrada."));
        o.setValor(ordemCompraItemCotacaoEntity.getValor());
        o.setEscolhida(ordemCompraItemCotacaoEntity.getEscolhida());
        o = ordemCompraItemCotacaoRepository.save(o);
        OrdemCompraItemCotacaoDTO dto = new OrdemCompraItemCotacaoDTO();
        dto.setValor(o.getValor());
        dto.setEscolhida(o.getEscolhida());
        dto.setId(o.getId());
        return dto;
    }

    public OrdemCompraItemCotacaoEntity read(Long id, OrdemCompraItemCotacaoEntity ordemCompraItemCotacaoEntity){
        return ordemCompraItemCotacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Ordem de compra não encontrada."));
    }
}
