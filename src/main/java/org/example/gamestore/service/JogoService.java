package org.example.gamestore.service;

import org.example.gamestore.dto.JogoRequestDTO;
import org.example.gamestore.dto.JogoResponseDTO;
import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.model.Jogo;
import org.example.gamestore.repository.DesenvolvedoraRepository;
import org.example.gamestore.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository repository;
    private final DesenvolvedoraRepository desenvolvedoraRepository;


    public JogoService(JogoRepository repository, DesenvolvedoraRepository desenvolvedoraRepository) {
        this.repository = repository;
        this.desenvolvedoraRepository =desenvolvedoraRepository;
    }

    public JogoResponseDTO buscarPorId(Long id){
         Jogo jogo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));

         return toResponse(jogo);
    }

    public List<JogoResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public JogoResponseDTO salvar(){

    }

    private Jogo toEntity(JogoRequestDTO dto){

    }

    private JogoResponseDTO toResponse(Jogo jogo){
        Desenvolvedora desenvolvedora = desenvolvedoraRepository.findById(jogo.getDesenvolvedora().getId())
                .orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada"));
        return new JogoResponseDTO(
                jogo.getId(),
                jogo.getTitulo(),
                jogo.getGenero(),
                jogo.getPreco(),
                jogo.getClassificacao(),
                jogo.getDescricao(),
                desenvolvedora.getId(),
                desenvolvedora.getNome()
        );
    }
}
