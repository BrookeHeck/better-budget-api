package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
