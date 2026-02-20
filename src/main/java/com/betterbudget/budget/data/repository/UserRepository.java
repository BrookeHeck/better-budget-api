package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
