package com.optical.net.staff.application;
import com.optical.net.staff.domain.Staff;
import org.springframework.stereotype.Service;

@Service
public class RegisterStaffAdapter implements RegisterStaff {

    private RegisterStaffPort registerStaffPort;

    @Override
    public Staff register(Staff staff) {

        return registerStaffPort.registerStaff(staff);
    }
}
