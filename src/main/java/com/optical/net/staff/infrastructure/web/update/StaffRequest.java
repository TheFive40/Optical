package com.optical.net.staff.infrastructure.web.update;

import jakarta.validation.constraints.*;

public record StaffRequest(
        @NotBlank String username,
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotBlank String name,
        @NotBlank String lastName
) {}
