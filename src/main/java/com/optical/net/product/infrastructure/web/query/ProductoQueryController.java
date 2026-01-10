package com.optical.net.product.infrastructure.web.query;

import com.optical.net.product.infrastructure.mapper.ProductMapper;
import com.optical.net.product.infrastructure.persistence.ProductPortAdapter;
import com.optical.net.product.infrastructure.web.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductoQueryController {

    private final ProductPortAdapter productPortAdapter;
    private final ProductMapper productMapper;

    public ProductoQueryController(ProductPortAdapter productPortAdapter, ProductMapper productMapper) {
        this.productPortAdapter = productPortAdapter;
        this.productMapper = productMapper;
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> readAll(){
        return ResponseEntity.ok(productMapper.toResponseList(productPortAdapter.readAll()));
    }
}
