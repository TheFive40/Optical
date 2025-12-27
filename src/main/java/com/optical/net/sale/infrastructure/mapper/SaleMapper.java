package com.optical.net.sale.infrastructure.mapper;

import com.optical.net.sale.domain.SaleDomain;
import com.optical.net.sale.infrastructure.persistence.Sale;
import com.optical.net.sale.infrastructure.web.SaleRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleDomain toDomain(Sale sale);

    SaleDomain fromRequest(SaleRequest request);

    Sale toEntity(SaleDomain domain);

}
