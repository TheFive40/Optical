package com.optical.net.patient.infrastructure.web;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PatientRestResponse(
        Long id,
        String name,
        String lastName,
        String phone,
        LocalDate birthdate,
        String medicalHistoryNro
) {}
