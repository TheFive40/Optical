package com.optical.net.appointment.infrastructure.mapper;

import com.optical.net.appointment.domain.AppointmentDomain;
import com.optical.net.appointment.infrastructure.persistence.Appointment;
import com.optical.net.appointment.infrastructure.web.AppointmentRequest;
import com.optical.net.appointment.infrastructure.web.AppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentResponse toResponse(AppointmentDomain domain);

    List<AppointmentResponse> toListResponse(List<AppointmentDomain> domains);

    List<AppointmentDomain> toListDomain(List<Appointment> appointments);

    @Mapping(source = "patient.name", target = "patientName")
    AppointmentDomain toDomain(Appointment appointment);

    AppointmentDomain fromRequest(AppointmentRequest request);

    Appointment toEntity(AppointmentDomain domain);

}
