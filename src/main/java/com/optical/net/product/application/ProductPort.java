package com.optical.net.product.application;

import com.optical.net.product.domain.ProductDomain;

import java.util.List;

public interface ProductPort {
    ProductDomain addProduct(ProductDomain productDomain);
    List<ProductDomain> readAll();
    void remove(Long id);

}
