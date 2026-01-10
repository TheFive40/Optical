package com.optical.net.staff.domain;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record StaffDomain(
        String username,
        String email,
        String password,
        String name,
        String lastName,
        LocalDate createdAt,
        Long id,
        String rolname

) {
}
