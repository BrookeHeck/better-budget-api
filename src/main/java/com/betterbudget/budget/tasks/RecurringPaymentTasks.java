package com.betterbudget.budget.tasks;

import com.betterbudget.budget.service.RecurringPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RecurringPaymentTasks {
    private final RecurringPaymentService recurringPaymentService;

    @Scheduled(cron = "0 0 0 * * * ")
    public void updateNextPaymentDate() {
        log.info("Running recurring payment task: update next payment");
        int numUpdated = recurringPaymentService.updateNextPaymentDate();
        log.info("Recurring payment task, update next payment complete. Updated {} records", numUpdated);
    }
}
