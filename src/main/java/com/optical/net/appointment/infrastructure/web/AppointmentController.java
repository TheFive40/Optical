package com.optical.net.appointment.infrastructure.web;

import com.optical.net.appointment.infrastructure.mapper.AppointmentMapper;
import com.optical.net.appointment.infrastructure.persistence.AppointmentPortAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentPortAdapter appointmentPortAdapter;
    private final AppointmentMapper appointmentMapper;

    public AppointmentController(AppointmentPortAdapter appointmentPortAdapter, AppointmentMapper appointmentMapper) {
        this.appointmentPortAdapter = appointmentPortAdapter;
        this.appointmentMapper = appointmentMapper;
    }
    @PostMapping("/schedule")
    public ResponseEntity<AppointmentResponse> schedule(AppointmentRequest request) {
        var domain = appointmentPortAdapter.save(appointmentMapper.fromRequest(request));
        return ResponseEntity.ok(new AppointmentResponse(domain.dateTime(), domain.reason(), domain.status(), domain.patient(), domain.createdAt()));
    }
}
