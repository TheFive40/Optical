package com.optical.net.accescontrol.infrastructure.persistence;

import com.optical.net.accescontrol.application.RolePort;
import com.optical.net.accescontrol.domain.RoleDomain;
import com.optical.net.accescontrol.infrastructure.mapper.RoleMapper;
import org.springframework.stereotype.Service;

@Service
public class RolePortAdapter implements RolePort {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RolePortAdapter(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDomain register(RoleDomain domain) {
        return roleMapper.toDomain(roleRepository.save(roleMapper.toEntity(domain)));
    }
}
