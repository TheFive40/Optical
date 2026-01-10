package com.optical.net.staff.application;

import com.optical.net.staff.infrastructure.persistence.ports.StaffTypePortAdapter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ChangeStaffTypeCaseAdapter implements ChangeStaffTypeUseCase{
    private final StaffTypePortAdapter staffTypePortAdapter;

    public ChangeStaffTypeCaseAdapter(StaffTypePortAdapter staffTypePortAdapter) {
        this.staffTypePortAdapter = staffTypePortAdapter;
    }

    @Override
    public void changeToOptometrist(Long staffId, String licenseNumber, String specialization, Integer yearsOfExperience) {
        staffTypePortAdapter.changeToOptometrist(staffId,licenseNumber,specialization,yearsOfExperience);
    }

    @Override
    public void changeToAdmin(Long staffId, String department, Integer accessLevel) {
        staffTypePortAdapter.changeToAdmin(staffId,department,accessLevel);
    }

    @Override
    public void changeToSeller(Long staffId, String employeeCode, BigDecimal salesTarget, BigDecimal commissionRate) {
        staffTypePortAdapter.changeToSeller(staffId,employeeCode,salesTarget,commissionRate);
    }
}
