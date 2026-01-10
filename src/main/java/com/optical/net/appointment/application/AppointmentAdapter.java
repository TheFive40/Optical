package com.optical.net.appointment.application;

import com.optical.net.appointment.domain.AppointmentDomain;
import com.optical.net.appointment.infrastructure.persistence.AppointmentPortAdapter;
import com.optical.net.patient.domain.PatientDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentAdapter implements  AppointmentCase{
    private final AppointmentPortAdapter appointmentPortAdapter;

    public AppointmentAdapter(AppointmentPortAdapter appointmentPortAdapter, AppointmentPortAdapter appointmentPortAdapter1) {
        this.appointmentPortAdapter = appointmentPortAdapter1;
    }

    @Override
    public AppointmentDomain schedule(AppointmentDomain domain) {
        return null;
    }

    @Override
    public List<AppointmentDomain> findByPatient(PatientDomain domain) {
        return appointmentPortAdapter.findByPatient(domain);
    }
}
