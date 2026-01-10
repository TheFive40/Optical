package com.optical.net.patient.infrastructure.web.query;

import com.optical.net.patient.application.PatientCrudAdapter;
import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import com.optical.net.patient.infrastructure.web.PatientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/patient")
@RestController
public class PatientQueryController {

    private final PatientCrudAdapter patientAdapter;
    private final PatientMapper patientMapper;

    public PatientQueryController(PatientCrudAdapter patientAdapter, PatientMapper patientMapper) {
        this.patientAdapter = patientAdapter;
        this.patientMapper = patientMapper;
    }
    @GetMapping("/")
    public ResponseEntity<List<PatientResponse>> readAll(){
        return ResponseEntity.ok(patientMapper.toListResponse(patientAdapter.readAll()));
   }



}
