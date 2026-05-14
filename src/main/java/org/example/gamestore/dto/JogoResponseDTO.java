package org.example.gamestore.dto;

public record JogoResponseDTO(
        Long id,
        String titulo,
        String genero,
        Double preco,
        String classificacao,
        String descricao,
        Long idDesenvolvedora,
        String nome
) {}
