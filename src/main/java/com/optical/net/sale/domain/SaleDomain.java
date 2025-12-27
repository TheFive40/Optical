package com.optical.net.sale.domain;
import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.sale.infrastructure.persistence.SaleDetail;
import com.optical.net.staff.domain.StaffDomain;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleDomain(
        Long id,

        BigDecimal total,

        String paymentStatus,

        LocalDateTime saleDate,

        PatientDomain patient,

        StaffDomain seller,

        List<SaleDetail> details
) {
}
