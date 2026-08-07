package com.knitly.knitly_api.controller;

import com.knitly.knitly_api.dto.UserRequestDTO;
import com.knitly.knitly_api.dto.UserResponseDTO;
import com.knitly.knitly_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO create(@RequestBody @Valid UserRequestDTO dto) {
        return service.create(dto);
    }
}
