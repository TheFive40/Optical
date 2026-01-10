package com.optical.net.appointment.infrastructure.persistence;

import com.optical.net.patient.infrastructure.persistance.Patient;
import com.optical.net.staff.infrastructure.persistence.optometrist.OptometristStaff;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "citas")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false, length = 255)
    private String reason;

    @Column(nullable = false, length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "optometrist_id")
    private OptometristStaff optometrist;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "Pendiente";
        }
    }
}
