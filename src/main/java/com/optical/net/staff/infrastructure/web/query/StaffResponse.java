package com.optical.net.staff.infrastructure.web.query;
import lombok.Builder;
import java.time.LocalDate;

@Builder
public record StaffResponse(
        Long id,
        String username,
        String email,
        String name,
        String lastName,
        LocalDate createdAt,
        String rolname
) {
}
