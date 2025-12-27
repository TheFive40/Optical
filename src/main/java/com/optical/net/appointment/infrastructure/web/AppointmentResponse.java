package com.optical.net.appointment.infrastructure.web;

import com.optical.net.patient.infrastructure.persistance.Patient;

import java.time.LocalDateTime;


public record AppointmentResponse(
        LocalDateTime dateTime,
        String reason,
        String status,
        Patient patient,
        LocalDateTime createdAt
) {
}
