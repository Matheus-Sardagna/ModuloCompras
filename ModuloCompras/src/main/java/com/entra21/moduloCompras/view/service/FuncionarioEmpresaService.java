package com.entra21.moduloCompras.view.service;


import com.entra21.moduloCompras.model.dto.FuncionarioEmpresaDTO;
import com.entra21.moduloCompras.model.entity.FuncionarioEmpresaEntity;
import com.entra21.moduloCompras.view.repository.FuncionarioEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioEmpresaService {

    @Autowired
    private FuncionarioEmpresaRepository funcionarioEmpresaRepository;

    public List<FuncionarioEmpresaDTO> getAll() {
        return funcionarioEmpresaRepository.findAll().stream().map(f -> {
            FuncionarioEmpresaDTO dto = new FuncionarioEmpresaDTO();
            dto.setId(f.getId());
            dto.setAtivo(f.getAtivo());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(FuncionarioEmpresaDTO input) {
        FuncionarioEmpresaEntity newEntity = new FuncionarioEmpresaEntity();
        newEntity.setAtivo(input.getAtivo());
        funcionarioEmpresaRepository.save(newEntity);
    }

    public FuncionarioEmpresaDTO getById(Long id) {
        FuncionarioEmpresaEntity f = funcionarioEmpresaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado."));
        FuncionarioEmpresaDTO dto = new FuncionarioEmpresaDTO();
        dto.setId(f.getId());
        dto.setAtivo(f.getAtivo());
        return dto;
    }

    public void delete(Long id) {
        funcionarioEmpresaRepository.deleteById(id);
    }

    public FuncionarioEmpresaDTO update(Long id, FuncionarioEmpresaEntity empresaEntity) {
        FuncionarioEmpresaEntity f = funcionarioEmpresaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado."));
        f.setAtivo(empresaEntity.getAtivo());
        f = funcionarioEmpresaRepository.save(f);
        FuncionarioEmpresaDTO dto = new FuncionarioEmpresaDTO();
        dto.setAtivo(f.getAtivo());
        dto.setId(f.getId());
        return dto;
    }

    public FuncionarioEmpresaEntity read(Long id, FuncionarioEmpresaEntity funcionarioEmpresaEntity){
        return funcionarioEmpresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
    }
}
