package com.optical.net.staff.infrastructure.web.register;

import com.optical.net.staff.application.StaffCaseAdapter;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.infrastructure.mapper.AdminMapper;
import com.optical.net.staff.infrastructure.mapper.OptometristStaffMapper;
import com.optical.net.staff.infrastructure.mapper.SellerStaffMapper;
import com.optical.net.staff.infrastructure.persistence.admin.AdminRequest;
import com.optical.net.staff.infrastructure.persistence.optometrist.OptometristRequest;
import com.optical.net.staff.infrastructure.persistence.seller.SellerRequest;
import com.optical.net.staff.infrastructure.web.query.StaffResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/staff/register")
@RequiredArgsConstructor
public class StaffRegisterController {
    private final StaffCaseAdapter staffCaseAdapter;
    private final AdminMapper adminMapper;
    private final SellerStaffMapper sellerStaffMapper;
    private final OptometristStaffMapper optometristStaffMapper;

    @PostMapping("/admin/register")
    public ResponseEntity<StaffResponse> register(@RequestBody AdminRequest request) {

        AdminDomain createStaffDomain = staffCaseAdapter.registerAdmin(adminMapper.fromRequest(request));
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .build());
    }


    @PostMapping("/seller/register")
    public ResponseEntity<StaffResponse> registerSeller(@RequestBody SellerRequest request) {
        SellerDomain createStaffDomain = staffCaseAdapter.registerSeller(sellerStaffMapper.fromRequest(request));
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .build());
    }

    @PostMapping("/optometrist/register")
    public ResponseEntity<StaffResponse> registerOptometrist(@RequestBody OptometristRequest request) {
        OptometristDomain createStaffDomain = staffCaseAdapter.registerOptometrist(optometristStaffMapper.fromRequest(request));
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .build());
    }

}
