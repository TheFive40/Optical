package com.optical.net.appointment.infrastructure.web;

import com.optical.net.patient.infrastructure.persistance.Patient;

import java.time.LocalDateTime;


public record AppointmentRequest(
        LocalDateTime dateTime,
        String reason,
        String status,
        String optometristName,
        String patientName,
        LocalDateTime createdAt
) {
}
