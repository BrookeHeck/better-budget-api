package com.betterbudget.budget.service;

import com.betterbudget.budget.data.entity_model.UserEntity;
import com.betterbudget.budget.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserEntity user) {

    }

}
