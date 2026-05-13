package org.example.gamestore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DesenvolvedoraRequestDTO (
        @NotBlank
        String nome,

        @NotBlank
        String pais,

        @NotNull
        Integer anoFundacao
) {}
