package com.optical.net.staff.infrastructure.web;
import com.optical.net.staff.application.RegisterStaffAdapter;
import com.optical.net.staff.domain.Staff;
import com.optical.net.staff.infrastructure.mapper.StaffMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class StaffRestController {

    private final RegisterStaffAdapter adapter;
    private final StaffMapper userRequestMapper;

    public StaffRestController(RegisterStaffAdapter adapter, StaffMapper userRequestMapper) {
        this.adapter = adapter;
        this.userRequestMapper = userRequestMapper;
    }

    @GetMapping("/sign")
    public ResponseEntity<StaffRestResponse> signUp(@RequestBody StaffRestRequest request){
        Staff createStaff = adapter.register(userRequestMapper.fromRestRequest(request));
        return ResponseEntity.ok(StaffRestResponse.builder()
                .name(createStaff.name())
                .email(createStaff.email())
                .lastName(createStaff.lastName())
                .username(createStaff.username())
                .name(createStaff.name())
                .build());
    }

}
