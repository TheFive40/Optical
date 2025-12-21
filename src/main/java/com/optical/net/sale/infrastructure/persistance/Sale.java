package com.optical.net.sale.infrastructure.persistance;

import com.optical.net.patient.infrastructure.persistance.Patient;
import com.optical.net.staff.infrastructure.persistence.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "ventas")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "estado_pago", nullable = false)
    private String paymentStatus;

    @Column(name = "fecha_venta")
    private LocalDateTime saleDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private UserEntity seller;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetail> details;

    @PrePersist
    protected void onCreate() {
        this.saleDate = LocalDateTime.now();
    }
}