package com.optical.net.staff.infrastructure.web.update;

import com.optical.net.staff.application.StaffCaseAdapter;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.infrastructure.web.query.StaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff/update")
@RequiredArgsConstructor
public class StaffUpdateController {
    private final StaffCaseAdapter staffCaseAdapter;

    @PutMapping("/admin/register/{id}")
    public ResponseEntity<StaffResponse> updateAdmin(@PathVariable Long id) {
        AdminDomain createStaffDomain = staffCaseAdapter.findAdmin(id);
        staffCaseAdapter.registerAdmin(createStaffDomain);
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .build());
    }

    @PutMapping("/seller/register/{id}")
    public ResponseEntity<StaffResponse> updateSeller(@PathVariable Long id, @RequestBody StaffRequest request) {
        SellerDomain createStaffDomain = staffCaseAdapter.findSeller(id);
        staffCaseAdapter.registerSeller(SellerDomain.builder()
                .name(request.name())
                .lastName(request.lastName())
                .email(request.email())
                .birthdate(createStaffDomain.birthdate())
                .commissionRate(createStaffDomain.commissionRate())
                .username(createStaffDomain.username())
                .salesTarget(createStaffDomain.salesTarget())
                .id(createStaffDomain.id())
                .employeeCode(createStaffDomain.employeeCode())
                .password(createStaffDomain.password())
                .build());
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .build());
    }

    @PutMapping("/optometrist/register/{id}")
    public ResponseEntity<StaffResponse> updateOptometrist(@PathVariable Long id) {
        OptometristDomain createStaffDomain = staffCaseAdapter.findOptometrist(id);
        staffCaseAdapter.registerOptometrist(createStaffDomain);
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .build());
    }

}
