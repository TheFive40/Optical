package com.optical.net.product.application;

import com.optical.net.product.domain.ProductDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCaseAdapter implements ProductCase {

    @Autowired
    private ProductPort productPort;

    @Override
    public ProductDomain addProduct(ProductDomain productDomain) {
        return productPort.addProduct(productDomain);
    }
}
