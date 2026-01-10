package com.optical.net.patient.infrastructure.web;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PatientResponse(
        Long id,
        String name,
        String lastName,
        String phone,
        LocalDate birthdate,
        String medicalHistoryNro,
        LocalDate lastVisit,
        String email
) {}
