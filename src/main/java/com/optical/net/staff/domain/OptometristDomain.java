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
    public String getStaffType(){
        return "OPTOMETRIST";
    }
    public String getFullName() {
        return name + " " + lastName;
    }
}
