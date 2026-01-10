package com.optical.net.product.infrastructure.mapper;
import com.optical.net.product.domain.ProductDomain;
import com.optical.net.product.infrastructure.persistence.Product;
import com.optical.net.product.infrastructure.web.ProductRequest;
import com.optical.net.product.infrastructure.web.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDomain productDomain);
    ProductDomain toDomain(Product product);
    ProductDomain fromRequest(ProductRequest product);
    List<Product> toEntityList(List<ProductDomain> domains);
    List<ProductDomain> toDomainlist(List<Product> products);
    List<ProductResponse> toResponseList(List<ProductDomain> domains);
}
