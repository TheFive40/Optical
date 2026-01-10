package com.optical.net.staff.infrastructure.persistence.optometrist;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OptometristRequest(
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

        @NotBlank(message = "El número de licencia es obligatorio")
        String licenseNumber,

        String specialization,
        Integer yearsOfExperience
) {}