package com.optical.net.staff.application;

import com.optical.net.staff.domain.Staff;

public interface RegisterStaffPort {
    Staff registerUser(Staff createStaff);
}
