package com.betterbudget.budget.api.controller;

import org.jspecify.annotations.Nullable;
import org.openapitools.api.UserApi;
import org.openapitools.model.User;
import org.springframework.http.ResponseEntity;

public class UserController implements UserApi {
    @Override
    public ResponseEntity<User> login() {
        return null;
    }

    @Override
    public ResponseEntity<User> register(@Nullable User user) {
        return null;
    }
}
