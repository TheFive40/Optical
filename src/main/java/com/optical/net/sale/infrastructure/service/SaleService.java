package com.optical.net.sale.infrastructure.service;

import com.optical.net.patient.infrastructure.mapper.PatientMapper;
import com.optical.net.patient.infrastructure.persistance.PatientRepository;
import com.optical.net.product.infrastructure.mapper.ProductMapper;
import com.optical.net.product.infrastructure.persistence.Product;
import com.optical.net.product.infrastructure.persistence.ProductRepository;
import com.optical.net.sale.domain.SaleDetailDomain;
import com.optical.net.sale.domain.SaleDomain;
import com.optical.net.sale.infrastructure.mapper.SaleMapper;
import com.optical.net.sale.infrastructure.persistence.SaleRepository;
import com.optical.net.sale.infrastructure.web.SaleDetailRequest;
import com.optical.net.sale.infrastructure.web.SaleRequest;
import com.optical.net.staff.infrastructure.mapper.SellerStaffMapper;
import com.optical.net.staff.infrastructure.persistence.seller.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private SellerStaffMapper sellerStaffMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public SaleDomain sell(SaleRequest request) {
        var patient = patientRepository.findByEmail(request.patientEmail());
        var seller = sellerRepository.findByUsername(request.sellerUsername()).getFirst();
        var details = request.detailRequest();
        List<Product> products = new ArrayList<>();
        long total = 0L;
        List<SaleDetailDomain> detailDomains = new ArrayList<>();
        for (SaleDetailRequest detail : details) {
            var product = productRepository.findById(detail.product_id()).orElseThrow();
            products.add(product);
            detailDomains.add(SaleDetailDomain.builder()
                    .subTotal(BigDecimal.valueOf(product.getSalePrice().longValue() * detail.amount()))
                    .amount(detail.amount())
                    .product(productMapper.toDomain(product))
                    .build());
            total += product.getSalePrice().longValue() * detail.amount();
        }

        return SaleDomain.builder().saleDate(LocalDateTime.now()).patient(patientMapper.toDomain(patient))
                .seller(sellerStaffMapper.toDomain(seller)).total(BigDecimal.valueOf(total))
                .details(detailDomains).build();
    }

}
