package com.optical.net.patient.infrastructure.web.update;

import com.optical.net.patient.application.PatientCrudAdapter;
import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import com.optical.net.patient.infrastructure.web.PatientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/patient/update")
@RestController
public class PatientUpdateController {

    private final PatientCrudAdapter patientCrudAdapter;
    private final PatientMapper patientMapper;

    public PatientUpdateController(PatientCrudAdapter patientCrudAdapter, PatientMapper patientMapper) {
        this.patientCrudAdapter = patientCrudAdapter;
        this.patientMapper = patientMapper;
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody PatientRequest request) {
        patientCrudAdapter.update(patientMapper.fromRequest(request));
        return ResponseEntity.ok("Paciente actualizado en la base de datos");
    }

}
