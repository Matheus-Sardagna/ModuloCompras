package com.entra21.moduloCompras.view.service;


import com.entra21.moduloCompras.model.dto.PessoaDTO;
import com.entra21.moduloCompras.model.entity.PessoaEntity;
import com.entra21.moduloCompras.view.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PessoaService implements UserDetailsService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> getAll() {
        return pessoaRepository.findAll().stream().map(p -> {
            PessoaDTO dto = new PessoaDTO();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setSobrenome(p.getSobrenome());
            dto.setTelefone(p.getTelefone());
            dto.setCpf(p.getCpf());
            dto.setAtivo(p.getAtivo());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(PessoaDTO input) {
        PessoaEntity newEntity = new PessoaEntity();
        newEntity.setNome(input.getNome());
        newEntity.setSobrenome(input.getSobrenome());
        newEntity.setTelefone(input.getTelefone());
        newEntity.setCpf(input.getCpf());
        pessoaRepository.save(newEntity);
    }

    public PessoaDTO getById(Long id) {
        PessoaEntity p = pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada."));
        PessoaDTO dto = new PessoaDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setSobrenome(p.getSobrenome());
        return dto;
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    public PessoaDTO update(Long id, PessoaEntity pessoaEntity) {
        PessoaEntity p = pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada."));
        p.setNome(pessoaEntity.getNome());
        p.setSobrenome(pessoaEntity.getSobrenome());
        p.setTelefone(pessoaEntity.getTelefone());
        p.setCpf(pessoaEntity.getCpf());
        p = pessoaRepository.save(p);
        PessoaDTO dto = new PessoaDTO();
        dto.setNome(p.getNome());
        dto.setSobrenome(p.getSobrenome());
        dto.setTelefone(p.getTelefone());
        dto.setCpf(p.getCpf());
        dto.setId(p.getId());
        return dto;
    }

    public PessoaEntity read(Long id, PessoaEntity pessoaEntity){
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PessoaEntity e = pessoaRepository.findByLogin(username);
        if (e == null) {
            throw new UsernameNotFoundException(username);
        }
        return e;
    }
}
