package com.entra21.moduloCompras.view.service;

import com.entra21.moduloCompras.model.dto.EmpresaDTO;
import com.entra21.moduloCompras.model.entity.EmpresaEntity;
import com.entra21.moduloCompras.view.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    public static EmpresaRepository empresaRepository;

    public List<EmpresaDTO> getAll() {
        return empresaRepository.findAll().stream().map(emp -> {
            EmpresaDTO dto = new EmpresaDTO();
            dto.setId(emp.getId());
            dto.setRazaoSocial(emp.getRazaoSocial());
            dto.setCnpj(emp.getCnpj());
            dto.setEndereco(emp.getEndereco());
            dto.setFornecedor(emp.getFornecedor());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(EmpresaDTO input) {
        EmpresaEntity newEntity = new EmpresaEntity();
        newEntity.setRazaoSocial(input.getRazaoSocial());
        newEntity.setCnpj(input.getCnpj());
        newEntity.setEndereco(input.getEndereco());
        newEntity.setFornecedor(input.getFornecedor());
        empresaRepository.save(newEntity);
    }

    public EmpresaDTO getById(Long id) {
        EmpresaEntity e = empresaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada."));
        EmpresaDTO dto = new EmpresaDTO();
        dto.setId(e.getId());
        dto.setRazaoSocial(e.getRazaoSocial());
        return dto;
    }

    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    public EmpresaDTO update(Long id, EmpresaEntity empresaEntity) {
        EmpresaEntity e = empresaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada."));
        e.setRazaoSocial(empresaEntity.getRazaoSocial());
        e.setEndereco(empresaEntity.getEndereco());
        e.setFornecedor(empresaEntity.getFornecedor());
        e.setCnpj(empresaEntity.getCnpj());
        e = empresaRepository.save(e);
        EmpresaDTO dto = new EmpresaDTO();
        dto.setRazaoSocial(e.getRazaoSocial());
        dto.setEndereco(e.getEndereco());
        dto.setFornecedor(e.getFornecedor());
        dto.setCnpj(e.getCnpj());
        dto.setId(e.getId());
        return dto;
    }

    public EmpresaEntity read(Long id, EmpresaEntity empresaEntity){
        return empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    }
}
