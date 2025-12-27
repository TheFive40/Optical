package com.optical.net.sale.application;

import com.optical.net.sale.domain.SaleDomain;
import com.optical.net.sale.infrastructure.persistence.SalePortAdapter;
import org.springframework.stereotype.Service;

@Service
public class SaleCaseAdapter implements SaleCase{
    private final SalePortAdapter salePortAdapter;

    public SaleCaseAdapter(SalePortAdapter salePortAdapter) {
        this.salePortAdapter = salePortAdapter;
    }

    @Override
    public SaleDomain toSell(SaleDomain domain) {
        return salePortAdapter.save(domain);
    }
}
