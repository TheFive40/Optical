package com.optical.net.patient.infrastructure.persistance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findByEmail(String email);
}
