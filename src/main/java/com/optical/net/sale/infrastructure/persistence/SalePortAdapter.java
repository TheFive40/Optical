package com.optical.net.sale.infrastructure.persistence;

import com.optical.net.sale.application.SalePort;
import com.optical.net.sale.domain.SaleDomain;
import com.optical.net.sale.infrastructure.mapper.SaleMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SalePortAdapter implements SalePort {
    private final SaleMapper saleMapper;
    private final SaleRepository saleRepository;

    public SalePortAdapter(SaleMapper saleMapper, SaleRepository saleRepository) {
        this.saleMapper = saleMapper;
        this.saleRepository = saleRepository;
    }

    @Override
    public SaleDomain save(SaleDomain domain) {
        return saleMapper.toDomain(saleRepository.save(saleMapper.toEntity(domain)));
    }
}
