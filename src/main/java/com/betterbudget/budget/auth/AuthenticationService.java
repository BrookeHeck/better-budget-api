package com.betterbudget.budget.auth;

import com.betterbudget.budget.data.entity_model.UserEntity;
import com.betterbudget.budget.data.repository.UserRepository;
import com.betterbudget.budget.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.LoginResponse;
import org.openapitools.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public LoginResponse authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                email, password));
        UserEntity user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("manager not found"));
        String jwt = jwtService.generateToken(user);
        LoginResponse res = new LoginResponse();
        res.token(jwt);
        res.user(userMapper.entityToApiModel(user));
        return res;
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = userRepo.save(userMapper.apiModelToEntity(user));
        String jwt = jwtService.generateToken(userEntity);
        return userMapper.entityToApiModel(userEntity);
    }

}
