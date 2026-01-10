package com.optical.net.sale.domain;

import com.optical.net.product.domain.ProductDomain;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SaleDetailDomain(
        Long id,
        Integer amount,
        BigDecimal subTotal,
        ProductDomain product
) {
}
