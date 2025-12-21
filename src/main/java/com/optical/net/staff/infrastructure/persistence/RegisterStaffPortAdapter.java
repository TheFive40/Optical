package com.optical.net.staff.infrastructure.persistence;

import com.optical.net.staff.application.RegisterStaffPort;
import com.optical.net.staff.domain.Staff;
import com.optical.net.staff.infrastructure.mapper.StaffMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterStaffPortAdapter implements RegisterStaffPort {
    private final StaffRepository staffRepository;

    private final StaffMapper staffMapper;

    public RegisterStaffPortAdapter(StaffMapper staffMapper, StaffRepository staffRepository) {
        this.staffMapper = staffMapper;
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff registerUser(Staff createStaff) {
        staffRepository.save(staffMapper.fromApplication(createStaff));
        return createStaff;
    }
}
