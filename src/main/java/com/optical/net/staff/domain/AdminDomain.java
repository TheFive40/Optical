package com.optical.net.staff.domain;

import lombok.Builder;

import java.time.LocalDate;

/**
 * Modelo de dominio para Administrador
 * Representa un usuario con permisos administrativos
 */
@Builder
public record AdminDomain(
        Long id,
        String username,
        String email,
        String password,
        String name,
        String lastName,
        LocalDate birthdate,
        Integer accessLevel,
        String department,
        boolean enabled
) {
    public static AdminDomain create(
            String username,
            String email,
            String password,
            String name,
            String lastName,
            LocalDate birthdate,
            Integer accessLevel,
            String department
    ) {
        return AdminDomain.builder()
                .username(username)
                .email(email)
                .password(password)
                .name(name)
                .lastName(lastName)
                .birthdate(birthdate)
                .accessLevel(accessLevel)
                .department(department)
                .enabled(true)
                .build();
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public boolean isSuperAdmin() {
        return accessLevel != null && accessLevel >= 5;
    }
}
