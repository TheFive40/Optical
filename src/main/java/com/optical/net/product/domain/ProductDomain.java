package com.optical.net.product.domain;

import java.math.BigDecimal;

public record ProductDomain(
        Long id,
        String brand,
        String model,
        int stock,
        String type,
        BigDecimal salePrice,
        String url

) {
    public boolean hasStock(int quantity) {
        return this.stock >= quantity;
    }

    public ProductDomain reduceStock(int quantity) {
        if (!hasStock(quantity)) {
            throw new IllegalStateException("Stock insuficiente");
        }
        return new ProductDomain(this.id, this.brand, this.model, this.stock - quantity, this.type,
                this.salePrice, this.url);
    }
}
