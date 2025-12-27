package com.optical.net.patient.infrastructure.mapper;

import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.persistance.Patient;
import com.optical.net.patient.infrastructure.web.PatientRestRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientDomain domain);
    PatientDomain fromRequest(PatientRestRequest request);
    PatientDomain toDomain(Patient patient);

}
