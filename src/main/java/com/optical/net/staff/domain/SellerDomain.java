package com.optical.net.staff.domain;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Modelo de dominio para Vendedor
 * Representa un empleado que realiza ventas de productos
 */
@Builder
public record SellerDomain(
        Long id,
        String username,
        String email,
        String password,
        String name,
        String lastName,
        LocalDate birthdate,
        BigDecimal commissionRate,
        BigDecimal salesTarget,
        String employeeCode,
        boolean enabled
) {
    public static SellerDomain create(
            String username,
            String email,
            String password,
            String name,
            String lastName,
            LocalDate birthdate,
            BigDecimal commissionRate,
            BigDecimal salesTarget,
            String employeeCode
    ) {
        return SellerDomain.builder()
                .username(username)
                .email(email)
                .password(password)
                .name(name)
                .lastName(lastName)
                .birthdate(birthdate)
                .commissionRate(commissionRate)
                .salesTarget(salesTarget)
                .employeeCode(employeeCode)
                .enabled(true)
                .build();
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public boolean hasCommission() {
        return commissionRate != null && commissionRate.compareTo(BigDecimal.ZERO) > 0;
    }
}
