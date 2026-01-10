package com.optical.net.staff.infrastructure.web.query;

import com.optical.net.staff.application.StaffCaseAdapter;
import com.optical.net.staff.infrastructure.mapper.StaffResponseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/staff")
public class StaffQueryController {

    private final StaffCaseAdapter adapter;
    private final StaffResponseMapper staffResponseMapper;

    public StaffQueryController(StaffCaseAdapter adapter, StaffResponseMapper staffResponseMapper) {
        this.adapter = adapter;
        this.staffResponseMapper = staffResponseMapper;
    }

    @GetMapping("/")
    public List<StaffResponse> readAllStaffs() {
        return staffResponseMapper.toResponse(adapter.readAllStaff());

    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable Long id) {

        return null;

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StaffResponse> readStaffByEmail(@PathVariable String email) {
        return ResponseEntity.ok(staffResponseMapper.toResponse(adapter.findByEmail(email)));
    }

}
