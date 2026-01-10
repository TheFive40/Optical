package com.optical.net.staff.infrastructure.persistence.seller;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SellerRequest(
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

        @DecimalMin(value = "0.0", message = "La comisión debe ser mayor o igual a 0")
        @DecimalMax(value = "100.0", message = "La comisión debe ser menor o igual a 100")
        BigDecimal commissionRate,

        @DecimalMin(value = "0.0", message = "La meta debe ser mayor o igual a 0")
        BigDecimal salesTarget,

        @NotBlank(message = "El código de empleado es obligatorio")
        String employeeCode
) {}
