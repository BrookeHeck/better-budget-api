package com.betterbudget.budget.service;

import com.betterbudget.budget.data.repository.TransactionRepository;
import com.betterbudget.budget.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepo;
    private final TransactionMapper transactionMapper;

    public Transaction createTransaction(Transaction transaction) {
        return transactionMapper.entityToApiModel(transactionRepo.save(transactionMapper.apiModelToEntity(transaction)));
    }

    public Transaction updateTransaction(Transaction transaction) {
        return transactionMapper.entityToApiModel(transactionRepo.save(transactionMapper.apiModelToEntity(transaction)));
    }

    public void deleteTransactionById(long transactionId) {
        transactionRepo.deleteById(transactionId);
    }

    public Transaction getTransactionById(long transactionId) {
        return transactionMapper.entityToApiModel(transactionRepo.getReferenceById(transactionId));
    }

    public List<Transaction> getTransactionsByUserId(long transactionId, LocalDate startDate, LocalDate endDate) {
        return transactionMapper
                .entityListToApiModelList(transactionRepo.findAllByUserId(transactionId, startDate, endDate));
    }
}
