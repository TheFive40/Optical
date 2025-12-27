package com.optical.net.product.infrastructure.mapper;
import com.optical.net.product.domain.ProductDomain;
import com.optical.net.product.infrastructure.persistence.Product;
import com.optical.net.product.infrastructure.web.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDomain productDomain);
    ProductDomain toDomain(Product product);
    ProductDomain fromRequest(ProductRequest product);

}
