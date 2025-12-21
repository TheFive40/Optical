package com.optical.net.user.application.auth;
import com.optical.net.user.domain.User;

public interface UserCase {
    User register(User user);
}
