package com.betterbudget.budget.service;

import com.betterbudget.budget.data.repository.UserRepository;
import com.betterbudget.budget.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final UserMapper userMapper;

    public User createUser(User user) {
        return userMapper.entityToApiModel(userRepo.save(userMapper.apiModelToEntity(user)));
    }

    public User login(String email, String password) {
        return userMapper.entityToApiModel(userRepo.login(email, password));
    }

}
