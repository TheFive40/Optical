package com.optical.net.staff.infrastructure.web.changetype;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ChangeStaffTypeRequest(
        @NotBlank
        String newType,

        // OPTOMETRIST
        String licenseNumber,
        String specialization,
        Integer yearsOfExperience,

        // SELLER
        String employeeCode,
        BigDecimal salesTarget,
        BigDecimal commissionRate,

        // ADMIN
        String department,
        Integer accessLevel
) {

}
