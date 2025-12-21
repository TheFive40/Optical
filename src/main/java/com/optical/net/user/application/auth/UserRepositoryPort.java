package com.optical.net.user.application.auth;

import com.optical.net.user.domain.User;

public interface UserRepositoryPort {
    User registerUser(User createUser);
}
