package com.optical.net.accescontrol.infrastructure.mapper;

import com.optical.net.accescontrol.domain.PermissionDomain;
import com.optical.net.accescontrol.infrastructure.persistence.Permission;
import com.optical.net.accescontrol.infrastructure.web.PermissionRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toEntity(PermissionDomain domain);

    PermissionDomain toDomain(Permission permission);

    PermissionDomain fromRequest(PermissionRequest request);

}
