package com.optical.net.product.infrastructure.web;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequest(
        Long id,
        String brand,
        String model,
        int stock,
        String type,
        BigDecimal salePrice,
        String url
) {
}
