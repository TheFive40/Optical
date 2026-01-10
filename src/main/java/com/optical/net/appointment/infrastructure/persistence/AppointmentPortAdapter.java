package com.optical.net.appointment.infrastructure.persistence;

import com.optical.net.appointment.application.AppointmentPort;
import com.optical.net.appointment.domain.AppointmentDomain;
import com.optical.net.appointment.infrastructure.mapper.AppointmentMapper;
import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentPortAdapter implements AppointmentPort {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final PatientMapper patientMapper;

    public AppointmentPortAdapter(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper, PatientMapper patientMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public AppointmentDomain save(AppointmentDomain domain) {
        return appointmentMapper.toDomain(appointmentRepository.save(appointmentMapper.toEntity(domain)));
    }

    @Override
    public List<AppointmentDomain> findByPatient(PatientDomain domain) {
        return appointmentMapper.toListDomain(appointmentRepository.searchAllByPatient(patientMapper.toEntity(domain)));
    }
}
