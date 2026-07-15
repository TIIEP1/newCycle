package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.config.TokenConfig;
import com.NewCycle.cashtrash.dtos.request.LoginRequest;
import com.NewCycle.cashtrash.dtos.request.RegisterUserRequest;
import com.NewCycle.cashtrash.dtos.response.LoginResponse;
import com.NewCycle.cashtrash.dtos.response.RegisterUserResponse;
import com.NewCycle.cashtrash.model.User;
import com.NewCycle.cashtrash.model.enums.TipoUser;
import com.NewCycle.cashtrash.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final TokenConfig tokenConfig;

    public AuthController(UserRepository repository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                          TokenConfig tokenConfig) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest register){
        User user = new User();
        user.setName(register.name());
        user.setEmail(register.email());
        user.setType(TipoUser.valueOf(register.tipoUsuario()));
        user.setCfp(register.cpf());
        user.setPassword(passwordEncoder.encode(register.password()));
        return ResponseEntity.ok(RegisterUserResponse.from(repository.save(user)));
    }
}
