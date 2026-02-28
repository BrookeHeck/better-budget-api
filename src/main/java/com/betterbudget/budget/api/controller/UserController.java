package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.UserApi;
import org.openapitools.model.LoginResponse;
import org.openapitools.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final AuthenticationService authService;

    @Override
    @PostMapping("/user/login")
    public ResponseEntity<LoginResponse> login(String authorization) {
        return new ResponseEntity<LoginResponse>(authService.authenticate("test"), HttpStatus.OK);
    }

    @Override
    @PostMapping("/user/register")
    public ResponseEntity<User> register(@Nullable User user) {
        return new ResponseEntity<User>(authService.register(user), HttpStatus.CREATED);
    }
}
