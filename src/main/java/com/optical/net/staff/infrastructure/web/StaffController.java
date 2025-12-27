package com.optical.net.staff.infrastructure.web;
import com.optical.net.staff.application.StaffCaseAdapter;
import com.optical.net.staff.domain.AdminDomain;
import com.optical.net.staff.domain.OptometristDomain;
import com.optical.net.staff.domain.SellerDomain;
import com.optical.net.staff.infrastructure.mapper.AdminMapper;
import com.optical.net.staff.infrastructure.mapper.OptometristStaffMapper;
import com.optical.net.staff.infrastructure.mapper.SellerStaffMapper;
import com.optical.net.staff.infrastructure.persistence.AdminRequest;
import com.optical.net.staff.infrastructure.persistence.OptometristRequest;
import com.optical.net.staff.infrastructure.persistence.SellerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffCaseAdapter adapter;
    private final AdminMapper staffRequestMapper;
    private final SellerStaffMapper sellerStaffMapper;
    private final OptometristStaffMapper optometristStaffMapper;

    public StaffController(StaffCaseAdapter adapter, AdminMapper staffRequestMapper, SellerStaffMapper sellerStaffMapper, OptometristStaffMapper optometristStaffMapper) {
        this.adapter = adapter;
        this.staffRequestMapper = staffRequestMapper;
        this.sellerStaffMapper = sellerStaffMapper;
        this.optometristStaffMapper = optometristStaffMapper;
    }

    @PostMapping("/admin/register")
    public ResponseEntity<StaffResponse> signUp(@RequestBody AdminRequest request){
        AdminDomain createStaffDomain = adapter.registerAdmin(staffRequestMapper.fromRequest(request));
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .name(createStaffDomain.name())
                .build());
    }

    @PostMapping("/seller/register")
    public ResponseEntity<StaffResponse> registerSeller(@RequestBody SellerRequest request){
        SellerDomain createStaffDomain = adapter.registerSeller(sellerStaffMapper.fromRequest(request));
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .name(createStaffDomain.name())
                .build());
    }
    @PostMapping("/optometrist/register")
    public ResponseEntity<StaffResponse> registerSeller(@RequestBody OptometristRequest request){
        OptometristDomain createStaffDomain = adapter.registerOptometrist(optometristStaffMapper.fromRequest(request));
        return ResponseEntity.ok(StaffResponse.builder()
                .name(createStaffDomain.name())
                .email(createStaffDomain.email())
                .lastName(createStaffDomain.lastName())
                .username(createStaffDomain.username())
                .name(createStaffDomain.name())
                .build());
    }
}
