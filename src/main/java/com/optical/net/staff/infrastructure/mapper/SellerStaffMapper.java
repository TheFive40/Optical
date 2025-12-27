package com.optical.net.staff.infrastructure.mapper;

import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.infrastructure.persistence.Seller;
import com.optical.net.staff.infrastructure.persistence.SellerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SellerStaffMapper {

    SellerDomain fromRequest(SellerRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "sales", ignore = true)
    Seller toEntity(SellerDomain domain);


    SellerDomain toDomain(Seller entity);
}

