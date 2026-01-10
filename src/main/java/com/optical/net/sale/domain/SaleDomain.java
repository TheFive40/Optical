package com.optical.net.sale.domain;
import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.staff.domain.SellerDomain;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SaleDomain(

        Long id,
        BigDecimal total,
        String paymentStatus,
        LocalDateTime saleDate,
        PatientDomain patient,
        SellerDomain seller,
        List<SaleDetailDomain> details
) {
}
