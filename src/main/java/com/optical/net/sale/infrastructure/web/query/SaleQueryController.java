package com.optical.net.sale.infrastructure.web.query;

import com.optical.net.sale.application.SaleCrudCaseAdapter;
import com.optical.net.sale.infrastructure.mapper.SaleMapper;
import com.optical.net.sale.infrastructure.web.SaleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/sale")
@RestController
public class SaleQueryController {

    private final SaleCrudCaseAdapter saleCrudCaseAdapter;
    private final SaleMapper saleMapper;

    public SaleQueryController(SaleCrudCaseAdapter saleCrudCaseAdapter, SaleMapper saleMapper) {
        this.saleCrudCaseAdapter = saleCrudCaseAdapter;
        this.saleMapper = saleMapper;
    }

    public List<SaleResponse> findAll(){
        var list = saleCrudCaseAdapter.findAll();
        return saleMapper.toListResponse(list);
    }

}
