package com.optical.net.recipe.infrastructure.persistance;

import com.optical.net.patient.infrastructure.persistance.Patient;
import com.optical.net.staff.infrastructure.persistence.StaffEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "recetas")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    // --- Ojo Derecho (OD) ---
    @Column(name = "od_esfera", precision = 4, scale = 2)
    private BigDecimal odSphere;

    @Column(name = "od_cilindro", precision = 4, scale = 2)
    private BigDecimal odCilynder;

    @Column(name = "od_eje")
    private Integer odAxis;

    @Column(name = "od_adicion", precision = 4, scale = 2)
    private BigDecimal odAddition;

    // --- Ojo Izquierdo (OI) ---
    @Column(name = "oi_esfera", precision = 4, scale = 2)
    private BigDecimal oiSphere;

    @Column(name = "oi_cilindro", precision = 4, scale = 2)
    private BigDecimal oiCilynder;

    @Column(name = "oi_eje")
    private Integer oiAxis;

    @Column(name = "oi_adicion", precision = 4, scale = 2)
    private BigDecimal oiAddition;

    @Column(name = "distancia_pupilar", precision = 4, scale = 2)
    private BigDecimal pupillaryDistance;

    @Column(columnDefinition = "TEXT")
    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "optometrista_id", nullable = false)
    private StaffEntity optometrist;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
}