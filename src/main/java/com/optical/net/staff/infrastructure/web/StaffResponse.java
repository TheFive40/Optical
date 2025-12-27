package com.optical.net.staff.infrastructure.web;

import com.optical.net.accescontrol.domain.RoleDomain;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record StaffResponse(
        Long id,
        String username,
        String email,
        String name,
        String lastName,
        LocalDateTime createdAt
) {
}
