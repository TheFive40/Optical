package com.optical.net.sale.infrastructure.web;

import com.optical.net.sale.infrastructure.mapper.SaleMapper;
import com.optical.net.sale.infrastructure.persistence.SalePortAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final SalePortAdapter salePortAdapter;
    private final SaleMapper saleMapper;

    public SaleController(SalePortAdapter salePortAdapter, SaleMapper saleMapper) {
        this.salePortAdapter = salePortAdapter;
        this.saleMapper = saleMapper;
    }
    @PostMapping("/sell")
    public ResponseEntity<SaleResponse> toSell(SaleRequest request) {
        var domain = salePortAdapter.save(saleMapper.fromRequest(request));
        return ResponseEntity.ok(new SaleResponse(domain.id(), domain.total(), domain.paymentStatus(),
                domain.saleDate()));
    }
}
