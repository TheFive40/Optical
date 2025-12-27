package com.optical.net.sale.application;

import com.optical.net.sale.domain.SaleDomain;

public interface SalePort {
    SaleDomain save(SaleDomain domain);
}
