package com.optical.net.accescontrol.infrastructure.web;

import com.optical.net.accescontrol.domain.PermissionDomain;
import com.optical.net.accescontrol.domain.RoleDomain;
import com.optical.net.accescontrol.infrastructure.mapper.PermissionMapper;
import com.optical.net.accescontrol.infrastructure.mapper.RoleMapper;
import com.optical.net.accescontrol.infrastructure.persistence.PermissionPortAdapter;
import com.optical.net.accescontrol.infrastructure.persistence.RolePortAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/access")
public class RoleController {

    private final PermissionMapper permissionMapper;
    private final PermissionPortAdapter permissionPortAdapter;
    private final RolePortAdapter rolePortAdapter;
    private final RoleMapper roleMapper;

    public RoleController(PermissionMapper permissionMapper, PermissionPortAdapter permissionPortAdapter, RolePortAdapter rolePortAdapter, RoleMapper roleMapper) {
        this.permissionMapper = permissionMapper;
        this.permissionPortAdapter = permissionPortAdapter;
        this.rolePortAdapter = rolePortAdapter;
        this.roleMapper = roleMapper;
    }

    @PostMapping("/permission/register")
    public ResponseEntity<PermissionResponse> registerPermission(PermissionRequest request) {
        PermissionDomain domain = permissionPortAdapter.register(permissionMapper.fromRequest(request));
        return ResponseEntity.ok(new PermissionResponse(domain.name()));
    }

    @PostMapping("/role/register")
    public ResponseEntity<RoleRestResponse> registerRole(RoleRestRequest request) {
        RoleDomain domain = rolePortAdapter.register(roleMapper.fromRequest(request));
        return ResponseEntity.ok(new RoleRestResponse(domain.id(), domain.name()));
    }

}
