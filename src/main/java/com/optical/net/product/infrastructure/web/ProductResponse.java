package com.optical.net.product.infrastructure.web;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        String brand,
        String model,
        String type,
        Integer stock,
        BigDecimal salePrice,
        String url
) {
}
