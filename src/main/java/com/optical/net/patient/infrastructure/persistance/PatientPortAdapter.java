package com.optical.net.patient.infrastructure.persistance;

import com.optical.net.patient.application.PatientPort;
import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientPortAdapter implements PatientPort {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientPortAdapter(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientDomain register(PatientDomain patientDomain) {
        return patientMapper.toDomain(patientRepository.save(patientMapper.toEntity(patientDomain)));
    }

    @Override
    public List<PatientDomain> readAll() {
        var it = patientRepository.findAll().iterator();
        List<PatientDomain> patientDomains = new ArrayList<>();
        while (it.hasNext()){
            var item = it.next();
            patientDomains.add(patientMapper.toDomain(item));
        }
        return patientDomains;
    }

    @Override
    public void update(PatientDomain domain) {
        register(domain);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
