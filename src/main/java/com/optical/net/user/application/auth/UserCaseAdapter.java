package com.optical.net.user.application.auth;
import com.optical.net.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserCaseAdapter implements UserCase {

    private UserRepositoryPort userRepositoryPort;

    @Override
    public User register(User user) {

        return userRepositoryPort.registerUser(user);
    }
}
