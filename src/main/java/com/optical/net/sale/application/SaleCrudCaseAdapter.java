package com.optical.net.sale.application;

import com.optical.net.sale.domain.SaleDomain;
import com.optical.net.sale.infrastructure.persistence.SalePortAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleCrudCaseAdapter implements SaleCrudCase {
    private final SalePortAdapter salePortAdapter;

    public SaleCrudCaseAdapter(SalePortAdapter salePortAdapter) {
        this.salePortAdapter = salePortAdapter;
    }

    @Override
    public SaleDomain toSell(SaleDomain domain) {
        return salePortAdapter.save(domain);
    }

    @Override
    public List<SaleDomain> findAll() {
        return salePortAdapter.findAll();
    }

    @Override
    public void remove(Long id) {
        salePortAdapter.remove(id);
    }
}
