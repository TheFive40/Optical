package com.optical.net.user.domain;

import lombok.Builder;

@Builder
public record User(
        String username, String email, String password, String name, String lastName) {
}
