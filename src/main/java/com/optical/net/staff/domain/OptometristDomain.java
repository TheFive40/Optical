package com.optical.net.staff.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record OptometristDomain(
        Long id,
        String username,
        String email,
        String password,
        String name,
        String lastName,
        LocalDate birthdate,
        String licenseNumber,
        String specialization,
        Integer yearsOfExperience,
        boolean enabled
) {
    public static OptometristDomain create(
            String username,
            String email,
            String password,
            String name,
            String lastName,
            LocalDate birthdate,
            String licenseNumber,
            String specialization,
            Integer yearsOfExperience
    ) {
        return OptometristDomain.builder()
                .username(username)
                .email(email)
                .password(password)
                .name(name)
                .lastName(lastName)
                .birthdate(birthdate)
                .licenseNumber(licenseNumber)
                .specialization(specialization)
                .yearsOfExperience(yearsOfExperience)
                .enabled(true)
                .build();
    }

    public String getFullName() {
        return name + " " + lastName;
    }
}
