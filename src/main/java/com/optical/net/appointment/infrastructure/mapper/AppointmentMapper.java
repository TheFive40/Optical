package com.optical.net.appointment.infrastructure.mapper;

import com.optical.net.appointment.domain.AppointmentDomain;
import com.optical.net.appointment.infrastructure.persistence.Appointment;
import com.optical.net.appointment.infrastructure.web.AppointmentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentDomain toDomain(Appointment appointment);

    AppointmentDomain fromRequest(AppointmentRequest request);

    Appointment toEntity(AppointmentDomain domain);

}
