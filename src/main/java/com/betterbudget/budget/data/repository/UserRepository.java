package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("""
        select u from UserEntity u where u.email=:EMAIL and u.password=:PASS
    """)
    UserEntity login(@Param("EMAIL") String email, @Param("PASS") String password);

    Optional<UserEntity> findByEmail(String email);
}
