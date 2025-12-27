package com.optical.net.appointment.domain;

import com.optical.net.patient.infrastructure.persistance.Patient;

import java.time.LocalDateTime;

public record AppointmentDomain(
        LocalDateTime dateTime,
        String reason,
        String status,
        Patient patient,
        LocalDateTime createdAt
) { }
