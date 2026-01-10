package com.optical.net.staff.application;

import java.math.BigDecimal;

public interface StaffTypePort {
    void changeToOptometrist(Long staffId,
                             String licenseNumber,
                             String specialization,
                             Integer yearsOfExperience);

    void changeToAdmin(Long staffId, String department,
                       Integer accessLevel);

    void changeToSeller(Long staffId, String employeeCode,
                        BigDecimal salesTarget, BigDecimal commissionRate);
}
