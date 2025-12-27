package com.optical.net.product.application;

import com.optical.net.product.domain.ProductDomain;

public interface ProductPort {
    ProductDomain addProduct(ProductDomain productDomain);
}
