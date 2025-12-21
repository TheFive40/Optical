package com.optical.net.user.infrastructure.persistence;

import com.optical.net.user.application.auth.UserRepositoryPort;
import com.optical.net.user.domain.User;
import com.optical.net.user.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserRepositoryAdapter(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User createUser) {
        userRepository.save(userMapper.fromApplication(createUser));
        return createUser;
    }
}
