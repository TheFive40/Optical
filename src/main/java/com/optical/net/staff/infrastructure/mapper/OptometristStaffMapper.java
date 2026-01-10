package com.optical.net.staff.infrastructure.mapper;

import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.infrastructure.persistence.optometrist.OptometristRequest;
import com.optical.net.staff.infrastructure.persistence.optometrist.OptometristStaff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OptometristStaffMapper {

    OptometristDomain fromRequest(OptometristRequest request);

    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "recipes", ignore = true)
    @Mapping(target = "appointments", ignore = true)

    OptometristStaff toEntity(OptometristDomain domain);

    OptometristDomain toDomain(OptometristStaff entity);

    List<OptometristDomain> toListDomain(Iterable<OptometristStaff> sellers);
}
