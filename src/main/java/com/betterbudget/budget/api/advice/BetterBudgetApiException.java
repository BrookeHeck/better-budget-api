package com.betterbudget.budget.api.advice;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BetterBudgetApiException extends RuntimeException {
    private final HttpStatus status;

    public BetterBudgetApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
