package com.optical.net.sale.infrastructure.persistence;

import com.optical.net.patient.infrastructure.persistance.Patient;
import com.optical.net.staff.infrastructure.persistence.staff.Staff;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Entity
@Table(name = "ventas")
@NoArgsConstructor
@AllArgsConstructor
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
    private Staff seller;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetail> details;

    @PrePersist
    protected void onCreate() {
        this.saleDate = LocalDateTime.now();
    }
}