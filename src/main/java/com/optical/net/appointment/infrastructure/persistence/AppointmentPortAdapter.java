package com.optical.net.appointment.infrastructure.persistence;

import com.optical.net.appointment.application.AppointmentPort;
import com.optical.net.appointment.domain.AppointmentDomain;
import com.optical.net.appointment.infrastructure.mapper.AppointmentMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentPortAdapter implements AppointmentPort {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentPortAdapter(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentDomain save(AppointmentDomain domain) {
        return appointmentMapper.toDomain(appointmentRepository.save(appointmentMapper.toEntity(domain)));
    }
}
