package com.optical.net.staff.infrastructure.persistence.ports;

import com.optical.net.staff.application.StaffTypePort;
import com.optical.net.staff.infrastructure.persistence.admin.Admin;
import com.optical.net.staff.infrastructure.persistence.optometrist.OptometristStaff;
import com.optical.net.staff.infrastructure.persistence.seller.Seller;
import com.optical.net.staff.infrastructure.persistence.staff.Staff;
import com.optical.net.staff.infrastructure.persistence.staff.StaffRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class StaffTypePortAdapter implements StaffTypePort {
    private final StaffRepository staffRepository;

    @Transactional
    @Override
    public void changeToOptometrist(Long staffId, String licenseNumber, String specialization, Integer yearsOfExperience) {
        Staff current = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        staffRepository.delete(current);
        staffRepository.flush();
        OptometristStaff optometrist = OptometristStaff.builder()
                .username(current.getUsername())
                .email(current.getEmail())
                .password(current.getPassword())
                .name(current.getName())
                .lastName(current.getLastName())
                .birthdate(current.getBirthdate())
                .enabled(current.isEnabled())
                .licenseNumber(licenseNumber)
                .specialization(specialization)
                .yearsOfExperience(yearsOfExperience)
                .build();


        staffRepository.save(optometrist);
    }
    @Transactional
    @Override
    public void changeToAdmin(Long staffId, String department, Integer accessLevel) {
        Staff current = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staffRepository.delete(current);
        staffRepository.flush();

        Admin admin = Admin.builder()
                .username(current.getUsername())
                .email(current.getEmail())
                .password(current.getPassword())
                .name(current.getName())
                .lastName(current.getLastName())
                .birthdate(current.getBirthdate())
                .enabled(current.isEnabled())
                .department(department)
                .accessLevel(accessLevel)
                .build();

        staffRepository.save(admin);
    }
    @Transactional
    @Override
    public void changeToSeller(Long staffId, String employeeCode, BigDecimal salesTarget, BigDecimal commissionRate) {
        Staff current = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staffRepository.delete(current);
        staffRepository.flush();

        Seller seller = Seller.builder()
                .username(current.getUsername())
                .email(current.getEmail())
                .password(current.getPassword())
                .name(current.getName())
                .lastName(current.getLastName())
                .birthdate(current.getBirthdate())
                .enabled(current.isEnabled())
                .employeeCode(employeeCode)
                .salesTarget(salesTarget)
                .commissionRate(commissionRate)
                .build();

        staffRepository.save(seller);
    }
}
