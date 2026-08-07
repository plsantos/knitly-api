package com.knitly.knitly_api.controller;

import com.knitly.knitly_api.dto.UserRequestDTO;
import com.knitly.knitly_api.dto.UserResponseDTO;
import com.knitly.knitly_api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@Tag(
        name = "Users",
        description = "Endpoints para gerenciamento de usuários"
)
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Criar usuário",
            description = "Cadastra um novo usuário na plataforma"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuário criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Usuário já cadastrado"
            )
    })
    public UserResponseDTO create(@RequestBody @Valid UserRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<UserResponseDTO> findAll () {
        return service.findAll();
    }
}
