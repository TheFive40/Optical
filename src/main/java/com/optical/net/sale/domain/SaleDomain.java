package com.optical.net.sale.domain;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SaleDomain(
        Long id,

        BigDecimal total,

        String paymentStatus,

        LocalDateTime saleDate
) {
}
