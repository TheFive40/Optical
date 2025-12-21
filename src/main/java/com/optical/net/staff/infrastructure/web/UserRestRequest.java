package com.optical.net.staff.infrastructure.web;

import jakarta.validation.constraints.*;

public record UserRestRequest(
        @NotBlank String username,
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotBlank String name,
        @NotBlank String lastName
) {}
