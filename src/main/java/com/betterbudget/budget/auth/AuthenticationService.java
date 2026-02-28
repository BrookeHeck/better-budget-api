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

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public LoginResponse authenticate(String header) {
        Map<Integer, String> emailPassword = decodeBasicAuthHeader(header);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                emailPassword.get(1), emailPassword.get(2)));
        UserEntity user = userRepo.findByEmail(emailPassword.get(1))
                .orElseThrow(() -> new UsernameNotFoundException("manager not found"));
        String jwt = jwtService.generateToken(user);
        LoginResponse res = new LoginResponse();
        res.token(jwt);
        res.user(userMapper.entityToApiModel(user));
        return res;
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(User.StatusEnum.ACTIVE);
        UserEntity userEntity = userRepo.save(userMapper.apiModelToEntity(user));
        String jwt = jwtService.generateToken(userEntity);
        return userMapper.entityToApiModel(userEntity);
    }

    public Map<Integer, String> decodeBasicAuthHeader(String header) {
        String base64Credentials = header.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
        final String[] values = credentials.split(":", 2);
        String email = values[0];
        String password = values[1];
        Map<Integer, String> emailPassword = new HashMap<>();
        emailPassword.put(1, email);
        emailPassword.put(2, password);
        return emailPassword;
    }

}
