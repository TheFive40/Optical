package com.optical.net.patient.infrastructure.web.register;

import com.optical.net.patient.application.PatientCrudAdapter;
import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import com.optical.net.patient.infrastructure.web.PatientRequest;
import com.optical.net.patient.infrastructure.web.PatientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientRegisterController {

    private final PatientMapper patientMapper;
    private final PatientCrudAdapter patientAdapter;

    public PatientRegisterController(PatientMapper patientMapper, PatientCrudAdapter patientAdapter) {
        this.patientMapper = patientMapper;
        this.patientAdapter = patientAdapter;
    }

    @PostMapping("/register")
    public ResponseEntity<PatientResponse> register(@RequestBody PatientRequest request) {
        PatientDomain domain = patientAdapter.register(patientMapper.fromRequest(request));
        return ResponseEntity.ok(PatientResponse.builder()
                .id(domain.id())
                .name(domain.name())
                .phone(domain.phone())
                .lastName(domain.lastName())
                .lastVisit(domain.lastVisit())
                .birthdate(domain.birthdate())
                .email(domain.email())
                .medicalHistoryNro(domain.medicalHistoryNro())
                .build());
    }

}
