package com.optical.net.patient.infrastructure.mapper;

import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.persistance.Patient;
import com.optical.net.patient.infrastructure.web.PatientRequest;
import com.optical.net.patient.infrastructure.web.PatientResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientDomain domain);
    PatientDomain fromRequest(PatientRequest request);
    PatientDomain toDomain(Patient patient);

    PatientResponse toResponse(PatientDomain domain);

    List<PatientResponse> toListResponse(List<PatientDomain> domains);
}
