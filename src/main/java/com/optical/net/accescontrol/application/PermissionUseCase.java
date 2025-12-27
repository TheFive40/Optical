package com.optical.net.accescontrol.application;

import com.optical.net.accescontrol.domain.PermissionDomain;

public interface PermissionUseCase {
    PermissionDomain register(PermissionDomain permissionDomain);
}
