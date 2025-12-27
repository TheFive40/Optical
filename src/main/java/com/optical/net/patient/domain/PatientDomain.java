package com.optical.net.patient.domain;

public record PatientDomain (
        Long id,
        String name,
        String lastName,
        String phone,
        String medicalHistoryNro
) {
}
