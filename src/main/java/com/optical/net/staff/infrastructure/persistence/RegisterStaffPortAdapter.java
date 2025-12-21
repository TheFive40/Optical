package com.optical.net.staff.infrastructure.persistence;

import com.optical.net.staff.application.RegisterStaffPort;
import com.optical.net.staff.domain.Staff;
import com.optical.net.staff.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterStaffPortAdapter implements RegisterStaffPort {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public RegisterStaffPortAdapter(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Staff registerUser(Staff createStaff) {
        userRepository.save(userMapper.fromApplication(createStaff));
        return createStaff;
    }
}
