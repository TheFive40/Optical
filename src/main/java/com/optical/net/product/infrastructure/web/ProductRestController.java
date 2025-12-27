package com.optical.net.product.infrastructure.web;

import com.optical.net.product.domain.ProductDomain;
import com.optical.net.product.infrastructure.mapper.ProductMapper;
import com.optical.net.product.infrastructure.persistence.ProductPortAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private final ProductPortAdapter productPortAdapter;
    private final ProductMapper productMapper;

    public ProductRestController(ProductPortAdapter productPortAdapter, ProductMapper productMapper) {
        this.productPortAdapter = productPortAdapter;
        this.productMapper = productMapper;
    }
    @PostMapping("/register")
    public ResponseEntity<ProductResponse> add(ProductRequest request){
      ProductDomain domain = productPortAdapter.addProduct(productMapper.fromRequest(request));
      return ResponseEntity.ok(ProductResponse.builder()
              .url(domain.url())
              .type(domain.type())
              .stock(domain.stock())
              .model(domain.model())
              .salePrice(domain.salePrice())
              .brand(domain.brand())
              .build());
    }

}
