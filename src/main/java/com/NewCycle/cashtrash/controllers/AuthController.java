package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.dtos.request.LoginRequest;
import com.NewCycle.cashtrash.dtos.request.RegisterUserRequest;
import com.NewCycle.cashtrash.dtos.response.LoginResponse;
import com.NewCycle.cashtrash.dtos.response.RegisterUserResponse;
import com.NewCycle.cashtrash.model.User;
import com.NewCycle.cashtrash.model.enums.TipoUser;
import com.NewCycle.cashtrash.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserRepository repository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest register){
        User user = new User();
        user.setName(register.name());
        user.setEmail(register.email());
        user.setType(TipoUser.valueOf(register.tipoUsuario()));
        user.setPassword(passwordEncoder.encode(register.password()));
        return ResponseEntity.ok(RegisterUserResponse.from(repository.save(user)));
    }
}
