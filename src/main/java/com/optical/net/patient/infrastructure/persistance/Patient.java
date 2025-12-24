package com.optical.net.patient.infrastructure.persistance;

import com.optical.net.appointment.infrastructure.persistence.Appointment;
import com.optical.net.recipe.infrastructure.persistence.Recipe;
import com.optical.net.sale.infrastructure.persistence.Sale;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "pacientes")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "apellido", nullable = false, length = 100)
    private String lastName;

    @Column(length = 20)
    private String phone;

    @Column(name = "codigo_telefono", length = 8)
    private String codePhone;

    @Column(name = "fecha_nacimiento")
    private LocalDate birthdate;

    @Column(name = "historial_clinico_nro", unique = true, nullable = false)
    private String medicalHistoryNro;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Sale> sales;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Recipe> recipes;
}
