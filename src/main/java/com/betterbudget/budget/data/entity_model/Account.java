package com.betterbudget.budget.data.entity_model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account implements Serializable {
    @Id
    @Column(name = "id")
    private Long accountId;
}
