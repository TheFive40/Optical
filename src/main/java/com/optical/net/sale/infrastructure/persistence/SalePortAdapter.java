package com.optical.net.sale.infrastructure.persistence;

import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import com.optical.net.sale.application.SalePort;
import com.optical.net.sale.domain.SaleDomain;
import com.optical.net.sale.infrastructure.mapper.SaleDetailMapper;
import com.optical.net.sale.infrastructure.mapper.SaleMapper;
import com.optical.net.staff.infrastructure.mapper.SellerStaffMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalePortAdapter implements SalePort {
    private final SaleMapper saleMapper;
    private final SaleRepository saleRepository;
    private final PatientMapper patientMapper;
    private final SellerStaffMapper sellerStaffMapper;
    private final SaleDetailMapper saleDetailMapper;


    public SalePortAdapter(SaleMapper saleMapper, SaleRepository saleRepository, PatientMapper patientMapper, SellerStaffMapper sellerStaffMapper, SaleDetailMapper saleDetailMapper) {
        this.saleMapper = saleMapper;
        this.saleRepository = saleRepository;
        this.patientMapper = patientMapper;
        this.sellerStaffMapper = sellerStaffMapper;
        this.saleDetailMapper = saleDetailMapper;
    }

    @Override
    public SaleDomain save(SaleDomain domain) {
        var sale = Sale.builder()
                .total(domain.total())
                .saleDate(domain.saleDate())
                .patient(patientMapper.toEntity(domain.patient()))
                .paymentStatus(domain.paymentStatus())
                .seller(sellerStaffMapper.toEntity(domain.seller()))
                .details(saleDetailMapper.toListEntity(domain.details()))
                .build();
        return saleMapper.toDomain(saleRepository.save(sale));
    }

    @Override
    public List<SaleDomain> findAll() {
        return saleMapper.toListDomain(saleRepository.findAll());
    }

    @Override
    public void remove(Long id) {
        saleRepository.removeById(id);
    }
}
