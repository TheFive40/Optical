package com.optical.net.accescontrol.infrastructure.persistence;

import com.optical.net.accescontrol.application.PermissionPort;
import com.optical.net.accescontrol.domain.PermissionDomain;
import com.optical.net.accescontrol.infrastructure.mapper.PermissionMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionPortAdapter implements PermissionPort {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionPortAdapter(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public PermissionDomain register(PermissionDomain permissionDomain){
        return permissionMapper.toDomain(permissionRepository.save(permissionMapper.toEntity(permissionDomain)));
    }
}
