package com.optical.net.accescontrol.application;

import com.optical.net.accescontrol.domain.RoleDomain;
import com.optical.net.accescontrol.infrastructure.persistence.RolePortAdapter;
import org.springframework.stereotype.Service;

@Service
public class RoleCase implements RoleUseCase{
    private final RolePortAdapter rolePortAdapter;

    public RoleCase(RolePortAdapter rolePortAdapter) {
        this.rolePortAdapter = rolePortAdapter;
    }

    @Override
    public RoleDomain register(RoleDomain domain) {
       return rolePortAdapter.register(domain);
    }
}
