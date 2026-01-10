package com.optical.net.appointment.application;

import com.optical.net.appointment.domain.AppointmentDomain;
import com.optical.net.patient.domain.PatientDomain;

import java.util.List;

public interface AppointmentPort {
    AppointmentDomain save(AppointmentDomain domain);
    List<AppointmentDomain> findByPatient(PatientDomain domain);

}
