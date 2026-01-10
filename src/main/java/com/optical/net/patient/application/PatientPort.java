package com.optical.net.patient.application;

import com.optical.net.patient.domain.PatientDomain;

import java.util.List;

public interface PatientPort {
    PatientDomain register(PatientDomain patientDomain);
    List<PatientDomain> readAll();
    void update(PatientDomain domain);
    void delete(Long id);
}
