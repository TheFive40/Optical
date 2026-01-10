package com.optical.net.patient.application;

import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.persistance.PatientPortAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientCrudAdapter implements PatientCrudCase {

    private final PatientPortAdapter patientPortAdapter;

    public PatientCrudAdapter(PatientPortAdapter patientPortAdapter) {
        this.patientPortAdapter = patientPortAdapter;
    }

    @Override
    public PatientDomain register(PatientDomain patientDomain) {
        return patientPortAdapter.register(patientDomain);
    }

    @Override
    public List<PatientDomain> readAll() {
        return patientPortAdapter.readAll();
    }

    @Override
    public void update(PatientDomain patientDomain) {
        register(patientDomain);
    }

    @Override
    public void delete(Long id) {
        patientPortAdapter.delete(id);
    }
}
