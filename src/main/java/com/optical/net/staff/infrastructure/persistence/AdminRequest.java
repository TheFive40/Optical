package com.optical.net.staff.infrastructure.persistence;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AdminRequest(
        @NotBlank(message = "El username es obligatorio")
        String username,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "La contraseña es obligatoria")
        String password,

        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotBlank(message = "El apellido es obligatorio")
        String lastName,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        LocalDate birthdate,

        @Min(value = 1, message = "El nivel de acceso debe ser al menos 1")
        @Max(value = 5, message = "El nivel de acceso debe ser máximo 5")
        Integer accessLevel,

        String department
) {}
