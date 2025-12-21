package com.optical.net.staff.infrastructure.web;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record StaffRestResponse(
        Long id,
        String username,
        String email,
        String name,
        String lastName,
        LocalDateTime createdAt
) {}
