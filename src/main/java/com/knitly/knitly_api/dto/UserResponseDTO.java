package com.knitly.knitly_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserResponseDTO(

        @Schema(
                description = "Identificador único do usuário",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Nome completo do usuário",
                example = "Paula Santos"
        )
        String name,

        @Schema(
                description = "E-mail cadastrado do usuário",
                example = "paula@email.com"
        )
        String email

) {
}
