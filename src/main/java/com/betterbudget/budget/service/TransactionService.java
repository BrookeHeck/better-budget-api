package com.betterbudget.budget.service;

import com.betterbudget.budget.api.advice.BetterBudgetApiException;
import com.betterbudget.budget.data.repository.TransactionRepository;
import com.betterbudget.budget.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepo;
    private final TransactionMapper transactionMapper;
    private final AccountService accountService;

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

    public Transaction createPaymentOrDepositTransaction(Transaction transaction) {
        if(transaction.getTransactionType() == Transaction.TransactionTypeEnum.PAYMENT && transaction.getAmount() >= 0) {
            throw new BetterBudgetApiException("Payment transaction must have negative amount.", HttpStatus.BAD_REQUEST);
        }
        if(transaction.getTransactionType() == Transaction.TransactionTypeEnum.DEPOSIT) {
            throw new BetterBudgetApiException("Deposit transaction must have positive amount.", HttpStatus.BAD_REQUEST);
        }
        Transaction createdTransaction = createTransaction(transaction);
        accountService.updateAccountBalance(transaction.getAccountId(), transaction.getAmount());
        return createdTransaction;
    }

    public Transaction createTransferTransaction() {
        return null;
    }
}
