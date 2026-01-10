package com.optical.net.patient.application;

import com.optical.net.patient.domain.PatientDomain;

import java.util.List;

public interface PatientCrudCase {
    PatientDomain register(PatientDomain patientDomain);
    List<PatientDomain> readAll();
    void update(PatientDomain patientDomain);
    void delete(Long id);
}
