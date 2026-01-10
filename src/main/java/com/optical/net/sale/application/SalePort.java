package com.optical.net.sale.application;

import com.optical.net.sale.domain.SaleDomain;

import java.util.List;

public interface SalePort {
    SaleDomain save(SaleDomain domain);
    List<SaleDomain> findAll();
    void remove(Long id);

}
