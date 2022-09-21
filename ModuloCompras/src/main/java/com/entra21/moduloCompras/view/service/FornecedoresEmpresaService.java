package com.entra21.moduloCompras.view.service;

import com.entra21.moduloCompras.model.dto.FornecedoresEmpresaDTO;
import com.entra21.moduloCompras.model.entity.FornecedoresEmpresaEntity;
import com.entra21.moduloCompras.view.repository.FornecedoresEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FornecedoresEmpresaService {
    @Autowired
    public static FornecedoresEmpresaRepository fornecedoresEmpresaRepository;

    public List<FornecedoresEmpresaDTO> getAll() {
        return fornecedoresEmpresaRepository.findAll().stream().map(f -> {
            FornecedoresEmpresaDTO dto = new FornecedoresEmpresaDTO();
            dto.setId(f.getId());
            dto.setAtivo(f.getAtivo());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(FornecedoresEmpresaDTO input) {
        FornecedoresEmpresaEntity newEntity = new FornecedoresEmpresaEntity();
        newEntity.setAtivo(input.getAtivo());
        fornecedoresEmpresaRepository.save(newEntity);
    }

    public FornecedoresEmpresaDTO getById(Long id) {
        FornecedoresEmpresaEntity f = fornecedoresEmpresaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
        FornecedoresEmpresaDTO dto = new FornecedoresEmpresaDTO();
        dto.setId(f.getId());
        dto.setAtivo(f.getAtivo());
        return dto;
    }

    public void delete(Long id) {
        fornecedoresEmpresaRepository.deleteById(id);
    }

    public FornecedoresEmpresaDTO update(Long id, FornecedoresEmpresaEntity fornecedoresEmpresaEntity) {
        FornecedoresEmpresaEntity f = fornecedoresEmpresaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
        f.setAtivo(fornecedoresEmpresaEntity.getAtivo());
        f = fornecedoresEmpresaRepository.save(f);
        FornecedoresEmpresaDTO dto = new FornecedoresEmpresaDTO();
        dto.setAtivo(f.getAtivo());
        dto.setId(f.getId());
        return dto;
    }

    public FornecedoresEmpresaEntity read(Long id, FornecedoresEmpresaEntity fornecedoresEmpresaEntity){
        return fornecedoresEmpresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado."));
    }
}
