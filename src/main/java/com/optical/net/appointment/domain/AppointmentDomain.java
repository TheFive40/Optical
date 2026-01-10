package com.optical.net.appointment.domain;


import java.time.LocalDateTime;

public record AppointmentDomain(
        LocalDateTime dateTime,
        String reason,
        String status,
        String optometristName,
        String patientName,
        LocalDateTime createdAt
) { }
