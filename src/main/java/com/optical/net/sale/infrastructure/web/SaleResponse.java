package com.optical.net.sale.infrastructure.web;
import com.optical.net.patient.domain.PatientDomain;
import com.optical.net.sale.domain.SaleDetailDomain;
import com.optical.net.staff.domain.SellerDomain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleResponse(
        Long id,
        BigDecimal total,
        String paymentStatus,
        LocalDateTime saleDate,
        PatientDomain patient,
        SellerDomain seller,
        List<SaleDetailDomain> details
) {
}
