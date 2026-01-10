package com.optical.net.appointment.infrastructure.web;

import com.optical.net.appointment.infrastructure.mapper.AppointmentMapper;
import com.optical.net.appointment.infrastructure.persistence.AppointmentPortAdapter;
import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import com.optical.net.patient.infrastructure.web.PatientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentPortAdapter appointmentPortAdapter;
    private final AppointmentMapper appointmentMapper;
    private final PatientMapper patientMapper;

    public AppointmentController(AppointmentPortAdapter appointmentPortAdapter, AppointmentMapper appointmentMapper, PatientMapper patientMapper) {
        this.appointmentPortAdapter = appointmentPortAdapter;
        this.appointmentMapper = appointmentMapper;
        this.patientMapper = patientMapper;
    }
    @PostMapping("/schedule")
    public ResponseEntity<AppointmentResponse> schedule(AppointmentRequest request) {
        var domain = appointmentPortAdapter.save(appointmentMapper.fromRequest(request));
        return ResponseEntity.ok(new AppointmentResponse(domain.dateTime(), domain.reason(), domain.status(),domain.optometristName(),
                domain.patientName(),domain.createdAt()));
    }


    @PostMapping("/byPatient/")
    public ResponseEntity<List<AppointmentResponse>> appointmentsByPatient(@RequestBody PatientRequest request) {
        var domain = appointmentPortAdapter.findByPatient(patientMapper.fromRequest(request));
        return ResponseEntity.ok(appointmentMapper.toListResponse(domain));
    }
}
