package com.betterbudget.budget.service;

import com.betterbudget.budget.data.entity_model.RecurringPaymentEntity;
import com.betterbudget.budget.data.repository.RecurringPaymentRepository;
import com.betterbudget.budget.mapper.RecurringPaymentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.RecurringPayment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.betterbudget.budget.data.specification.RecurringPaymentSpec.hasPastPayment;

@Service
@RequiredArgsConstructor
@Slf4j
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

    public int updateNextPaymentDate() {
        List<RecurringPaymentEntity> entities = recurringPaymentRepo.findAll(hasPastPayment());
        entities.forEach(r -> {
            try {
                LocalDate newPaymentDate = getNextPaymentDate(r.getPaymentInterval(), r.getNextPaymentDate());
                r.setNextPaymentDate(newPaymentDate);
                recurringPaymentRepo.save(r);
            } catch (Exception e) {
                log.error("Error updating recurring payment next payment date with id: {}", r.getRecurringPaymentId(), e);
            }
        });
        return entities.size();
    }

    private LocalDate getNextPaymentDate(RecurringPayment.PaymentIntervalEnum interval, LocalDate paymentDate) {
        return switch (interval) {
            case WEEKLY -> paymentDate.plusWeeks(1);
            case MONTHLY -> paymentDate.plusMonths(1);
            case BIMONTHLY -> paymentDate.plusWeeks(6);
            case QUARTERLY -> paymentDate.plusMonths(3);
            case BIANNUALLY -> paymentDate.plusMonths(6);
            case ANNUALLY -> paymentDate.plusYears(1);
        };
    }
}
