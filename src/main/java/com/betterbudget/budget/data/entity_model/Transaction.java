package com.betterbudget.budget.data.entity_model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long transactionId;

    private String category;

    private double amount;

    private String description;

    @ManyToOne
    private Account account;

    @ManyToOne
    private User user;
}
