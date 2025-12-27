package com.optical.net.product.infrastructure.persistence;


import com.optical.net.product.application.ProductPort;
import com.optical.net.product.domain.ProductDomain;
import com.optical.net.product.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPortAdapter implements ProductPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductPortAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDomain addProduct(ProductDomain productDomain) {
        return productMapper.toDomain(productRepository.save(productMapper.toEntity(productDomain)));
    }
}
