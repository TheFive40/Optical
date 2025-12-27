package com.optical.net.patient.infrastructure.web;

import com.optical.net.patient.application.PatientAdapter;
import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import com.optical.net.patient.infrastructure.persistance.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {

    private final PatientMapper patientMapper;
    private final PatientAdapter patientAdapter;

    public PatientRestController(PatientMapper patientMapper, PatientAdapter patientAdapter) {
        this.patientMapper = patientMapper;
        this.patientAdapter = patientAdapter;
    }
    @PostMapping("/register")
    public ResponseEntity<PatientRestResponse> register(PatientRestRequest request) {
        PatientDomain domain = patientAdapter.register(patientMapper.fromRequest(request));
        return ResponseEntity.ok(PatientRestResponse.builder()
                .id(domain.id())
                .name(domain.name())
                .phone(domain.phone())
                .lastName(domain.lastName())
                .medicalHistoryNro(domain.medicalHistoryNro())
                .build());
    }

}
