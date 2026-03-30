package com.betterbudget.budget.service;

import com.betterbudget.budget.data.repository.RecurringPaymentRepository;
import com.betterbudget.budget.mapper.RecurringPaymentMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.RecurringPayment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecurringPaymentService {
    private final RecurringPaymentRepository recurringPaymentRepo;
    private final RecurringPaymentMapper mapper;

    public List<RecurringPayment> getRecurringPaymentsByUserId(long userId) {
        return mapper.entityListToApiModel(recurringPaymentRepo.getRecurringPaymentEntitiesByUserId(userId));
    }

    public RecurringPayment saveRecurringPayment(RecurringPayment recurringPayment) {
        return mapper.entityToApiModel(recurringPaymentRepo.save(mapper.apiModelToEntity(recurringPayment)));
    }

    public void deleteRecurringPaymentById(long recurringPaymentId) {
        recurringPaymentRepo.deleteById(recurringPaymentId);
    }
}
