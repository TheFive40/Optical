package com.optical.net.staff.infrastructure.web;
import com.optical.net.staff.application.RegisterStaffAdapter;
import com.optical.net.staff.domain.Staff;
import com.optical.net.staff.infrastructure.mapper.StaffMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/staff")
public class StaffRestController {

    private final RegisterStaffAdapter adapter;
    private final StaffMapper staffRequestMapper;

    public StaffRestController(RegisterStaffAdapter adapter, StaffMapper staffRequestMapper) {
        this.adapter = adapter;
        this.staffRequestMapper = staffRequestMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<StaffRestResponse> signUp(@RequestBody StaffRestRequest request){
        Staff createStaff = adapter.register(staffRequestMapper.fromRestRequest(request));
        return ResponseEntity.ok(StaffRestResponse.builder()
                .name(createStaff.name())
                .email(createStaff.email())
                .lastName(createStaff.lastName())
                .username(createStaff.username())
                .name(createStaff.name())
                .build());
    }

}
