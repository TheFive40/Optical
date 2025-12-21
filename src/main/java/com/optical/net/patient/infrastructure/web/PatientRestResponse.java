package com.optical.net.patient.infrastructure.web;

import java.time.LocalDate;

public record PatientRestResponse(
        Long id,
        String name,
        String lastName,
        String phone,
        LocalDate birthdate,
        String medicalHistoryNro
) {}
