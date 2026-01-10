package com.optical.net.appointment.infrastructure.persistence;

import com.optical.net.patient.infrastructure.persistance.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
    List<Appointment> searchAllByPatient(Patient patient);

    Patient patient(Patient patient);
}
