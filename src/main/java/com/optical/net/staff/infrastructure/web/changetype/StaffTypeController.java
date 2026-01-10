package com.optical.net.staff.infrastructure.web.changetype;

import com.optical.net.staff.infrastructure.persistence.ports.StaffTypePortAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff/type")
public class StaffTypeController {
    private final StaffTypePortAdapter staffTypePort;

    public StaffTypeController(StaffTypePortAdapter staffTypePort) {
        this.staffTypePort = staffTypePort;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeType(
            @PathVariable Long id,
            @RequestBody ChangeStaffTypeRequest request
    ) {
        switch (request.newType()) {
            case "OPTOMETRIST" ->
                    staffTypePort.changeToOptometrist(
                            id,
                            request.licenseNumber(),
                            request.specialization(),
                            request.yearsOfExperience()
                    );

            case "SELLER" ->
                    staffTypePort.changeToSeller(
                            id,
                            request.employeeCode(),
                            request.salesTarget(),
                            request.commissionRate()
                    );

            case "ADMIN" ->
                    staffTypePort.changeToAdmin(
                            id,
                            request.department(),
                            request.accessLevel()
                    );

            default -> throw new IllegalArgumentException("Invalid staff type");
        }
        return ResponseEntity.ok().build();
    }
}
