package com.optical.net.patient.infrastructure.web;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record PatientRestRequest(
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String phone,
        @NotNull LocalDate birthdate,
        String medicalHistoryNro
) {}
