package com.optical.net.patient.domain;

import java.time.LocalDate;

public record PatientDomain (
        Long id,
        String name,
        LocalDate birthdate,
        String lastName,
        String phone,
        String medicalHistoryNro,
        LocalDate lastVisit,
        String email
) {
}
