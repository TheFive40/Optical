package com.optical.net.user.infrastructure.web;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserRestResponse(
        Long id,
        String username,
        String email,
        String name,
        String lastName,
        LocalDateTime createdAt
) {}
