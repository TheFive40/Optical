package com.optical.net.patient.application;

import com.optical.net.patient.domain.PatientDomain;

public interface PatientPort {
    PatientDomain register(PatientDomain patientDomain);
}
