package com.optical.net.sale.infrastructure.web;

public record SaleDetailRequest(
        Long product_id,
        int amount
) {
}
