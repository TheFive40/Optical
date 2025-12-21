package com.optical.net.staff.domain;

import lombok.Builder;

@Builder
public record Staff(
        String username, String email, String password, String name, String lastName) {
}
