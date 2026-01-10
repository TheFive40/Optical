package com.optical.net.patient.infrastructure.web.delete;
import com.optical.net.patient.application.PatientCrudAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/patient/delete")
@RestController
public class PatientDeleteController {

    private final PatientCrudAdapter patientCrudAdapter;

    public PatientDeleteController(PatientCrudAdapter patientCrudAdapter) {
        this.patientCrudAdapter = patientCrudAdapter;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        patientCrudAdapter.delete(id);
        return ResponseEntity.ok("Paciente  eliminado de la base de datos");
    }

}
