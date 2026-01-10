package com.optical.net.patient.infrastructure.web;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record PatientRequest(
        Long id,
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String phone,
        @NotNull LocalDate birthdate,
        String medicalHistoryNro,
        LocalDate lastVisit,
        String email
) {}
