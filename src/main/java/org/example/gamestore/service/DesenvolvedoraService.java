package org.example.gamestore.service;

import org.example.gamestore.dto.DesenvolvedoraRequestDTO;
import org.example.gamestore.dto.DesenvolvedoraResponseDTO;
import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.repository.DesenvolvedoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedoraService {

    private final DesenvolvedoraRepository repository;

    public DesenvolvedoraService(DesenvolvedoraRepository repository){
        this.repository = repository;
    }

    public DesenvolvedoraResponseDTO buscarPorId(Long id){
        Desenvolvedora desenvolvedora = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada"));
        return toResponse(desenvolvedora);
    }

    public List<DesenvolvedoraResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public DesenvolvedoraResponseDTO atualizar(Long id, DesenvolvedoraRequestDTO dto){
        Desenvolvedora existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desenvolvedora não existe"));
        existente.setNome(dto.nome());
        existente.setPais(dto.pais());
        existente.setAnoFundacao(dto.anoFundacao());

        Desenvolvedora salvo = repository.save(existente);
        return toResponse(salvo);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public DesenvolvedoraResponseDTO salvar(DesenvolvedoraRequestDTO dto){
        Desenvolvedora desenvolvedora =  toEntity(dto);
        Desenvolvedora salvo = repository.save(desenvolvedora);
        return toResponse(salvo);
    }

    private DesenvolvedoraResponseDTO toResponse(Desenvolvedora desenvolvedora){
        return new DesenvolvedoraResponseDTO(
                desenvolvedora.getId(),
                desenvolvedora.getNome(),
                desenvolvedora.getPais(),
                desenvolvedora.getAnoFundacao()
        );
    }

    private Desenvolvedora toEntity(DesenvolvedoraRequestDTO dto){
        Desenvolvedora desenvolvedora = new Desenvolvedora();
        desenvolvedora.setNome(dto.nome());
        desenvolvedora.setPais(dto.pais());
        desenvolvedora.setAnoFundacao(dto.anoFundacao());

        return desenvolvedora;
    }

}
