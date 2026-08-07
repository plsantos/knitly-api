package com.knitly.knitly_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @Schema(
                description = "Nome completo do usuário",
                example = "Paula Santos"
        )
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @Schema(
                description = "E-mail utilizado para cadastro e login",
                example = "paula@email.com"
        )
        @Email(message = "E-mail inválido")
        @NotBlank(message = "O e-mail é obrigatório")
        String email,

        @Schema(
                description = "Senha de acesso do usuário",
                example = "Senha@123"
        )
        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
        String password
) {
}
