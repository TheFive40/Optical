package com.optical.net.accescontrol.infrastructure.mapper;

import com.optical.net.accescontrol.domain.RoleDomain;
import com.optical.net.accescontrol.infrastructure.persistence.Role;
import com.optical.net.accescontrol.infrastructure.web.RoleRestRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDomain domain);

    RoleDomain toDomain(Role role);

    RoleDomain fromRequest(RoleRestRequest request);

}
