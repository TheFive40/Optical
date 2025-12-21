package com.optical.net.user.infrastructure.controller;
import com.optical.net.user.application.auth.UserCaseAdapter;
import com.optical.net.user.domain.User;
import com.optical.net.user.infrastructure.web.UserRestRequest;
import com.optical.net.user.infrastructure.web.UserRestResponse;
import com.optical.net.user.infrastructure.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserCaseAdapter adapter;
    private final UserMapper userRequestMapper;

    public UserRestController(UserCaseAdapter adapter, UserMapper userRequestMapper) {
        this.adapter = adapter;
        this.userRequestMapper = userRequestMapper;
    }

    @GetMapping("/sign")
    public ResponseEntity<UserRestResponse> signUp(@RequestBody UserRestRequest request){
        User createUser = adapter.register(userRequestMapper.fromRestRequest(request));
        return ResponseEntity.ok(UserRestResponse.builder()
                .name(createUser.name())
                .email(createUser.email())
                .lastName(createUser.lastName())
                .username(createUser.username())
                .name(createUser.name())
                .build());
    }

}
