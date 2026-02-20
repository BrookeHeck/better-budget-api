package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.UserApi;
import org.openapitools.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public ResponseEntity<User> login() {
        return null;
    }

    @Override
    public ResponseEntity<User> register(@Nullable User user) {
        return null;
    }
}
