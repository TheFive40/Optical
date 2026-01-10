package com.optical.net.sale.infrastructure.mapper;
import com.optical.net.sale.domain.SaleDomain;
import com.optical.net.sale.infrastructure.persistence.Sale;
import com.optical.net.sale.infrastructure.web.SaleRequest;
import com.optical.net.sale.infrastructure.web.SaleResponse;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    List<SaleResponse> toListResponse(List<SaleDomain> domains);

    SaleResponse toResponse(SaleDomain domain);

    List<SaleDomain> toListDomain(List<Sale> sales);

    SaleDomain toDomain(Sale sale);

    SaleDomain fromRequest(SaleRequest request);

    Sale toEntity(SaleDomain domain);

}
