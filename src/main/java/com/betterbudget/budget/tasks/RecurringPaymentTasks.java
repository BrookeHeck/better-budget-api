package com.betterbudget.budget.tasks;

import com.betterbudget.budget.service.RecurringPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecurringPaymentTasks {
    private final RecurringPaymentService recurringPaymentService;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateNextPaymentDate() {

    }
}
