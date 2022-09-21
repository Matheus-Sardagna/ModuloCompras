package com.entra21.moduloCompras.view.service;



import com.entra21.moduloCompras.model.dto.OrcamentoDTO;
import com.entra21.moduloCompras.model.entity.OrcamentoEntity;
import com.entra21.moduloCompras.view.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrcamentoService {
    @Autowired
    public static OrcamentoRepository orcamentoRepository;

    public List<OrcamentoDTO> getAll() {
        return orcamentoRepository.findAll().stream().map(o -> {
            OrcamentoDTO dto = new OrcamentoDTO();
            dto.setId(o.getId());
            dto.setDescricao(o.getDescricao());
            return dto;
        }).collect(Collectors.toList());
    }

    public void save(OrcamentoDTO input) {
        OrcamentoEntity newEntity = new OrcamentoEntity();
        newEntity.setDescricao(input.getDescricao());
        orcamentoRepository.save(newEntity);
    }

    public OrcamentoDTO getById(Long id) {
        OrcamentoEntity o = orcamentoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orçamento não encontrado."));
        OrcamentoDTO dto = new OrcamentoDTO();
        dto.setId(o.getId());
        dto.setDescricao(o.getDescricao());
        return dto;
    }

    public void delete(Long id) {
        orcamentoRepository.deleteById(id);
    }

    public OrcamentoDTO update(Long id, OrcamentoEntity orcamentoEntity) {
        OrcamentoEntity o = orcamentoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orçamento não encontrado."));
        o.setDescricao(orcamentoEntity.getDescricao());
        o = orcamentoRepository.save(o);
        OrcamentoDTO dto = new OrcamentoDTO();
        dto.setDescricao(o.getDescricao());
        dto.setId(o.getId());
        return dto;
    }

    public OrcamentoEntity read(Long id, OrcamentoEntity orcamentoEntity){
        return orcamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Orçamento não encontrado."));
    }
}
