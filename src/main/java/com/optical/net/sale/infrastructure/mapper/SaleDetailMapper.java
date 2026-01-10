package com.optical.net.sale.infrastructure.mapper;
import com.optical.net.product.infrastructure.mapper.ProductMapper;
import com.optical.net.sale.domain.SaleDetailDomain;
import com.optical.net.sale.infrastructure.persistence.SaleDetail;
import com.optical.net.sale.infrastructure.web.SaleDetailRequest;
import com.optical.net.staff.infrastructure.mapper.SellerStaffMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = { ProductMapper.class, SellerStaffMapper.class, SaleDetailMapper.class })
public interface SaleDetailMapper {

    List<SaleDetail> toListEntity(List<SaleDetailDomain> detailDomains);

    SaleDetailDomain toDomain(SaleDetail detail);

    SaleDetailDomain fromRequest(SaleDetailRequest request);

    SaleDetail toEntity(SaleDetailDomain detailDomain);


}
