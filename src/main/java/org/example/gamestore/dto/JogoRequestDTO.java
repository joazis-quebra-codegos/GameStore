package org.example.gamestore.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record JogoRequestDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String genero,
        @NotNull
        @Positive
        @Max(value = 2000)
        Double preco,
        @NotBlank
        String classificacao,
        @NotBlank
        String descricao,
        @NotNull
        Long idDesenvolvedora,
        @NotBlank
        String nome
) {}
