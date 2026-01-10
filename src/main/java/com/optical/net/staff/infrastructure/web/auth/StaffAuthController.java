package com.optical.net.staff.infrastructure.web.auth;

import com.optical.net.staff.application.StaffCaseAdapter;
import com.optical.net.staff.infrastructure.persistence.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/staff/auth")
@RequiredArgsConstructor
public class StaffAuthController {
    private final StaffCaseAdapter staffCaseAdapter;

    @PostMapping("/admin/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest request) {
        if (staffCaseAdapter.validateCredentials(request.email(), request.password()))
            return ResponseEntity.ok("Autorizado, puede ingresar");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error credenciales no validas, intente de nuevo");
    }


}
