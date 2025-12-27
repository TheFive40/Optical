package com.optical.net.patient.application;

import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.persistance.PatientPortAdapter;
import org.springframework.stereotype.Service;

@Service
public class PatientAdapter implements PatientCase {

    private final PatientPortAdapter patientPortAdapter;

    public PatientAdapter(PatientPortAdapter patientPortAdapter) {
        this.patientPortAdapter = patientPortAdapter;
    }

    @Override
    public PatientDomain register(PatientDomain patientDomain) {
        return patientPortAdapter.register(patientDomain);
    }
}
