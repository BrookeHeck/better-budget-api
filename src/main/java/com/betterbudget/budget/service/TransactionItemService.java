package com.betterbudget.budget.service;

import com.betterbudget.budget.data.entity_model.TransactionItemEntity;
import com.betterbudget.budget.data.repository.TransactionItemRepository;
import com.betterbudget.budget.mapper.TransactionItemMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.TransactionItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionItemService {
    private final TransactionItemRepository transactionItemRepo;
    private final TransactionItemMapper transactionItemMapper;

    public TransactionItem createTransactionItem(TransactionItem transactionItem) {
        return transactionItemMapper.entityModelToApiModel(
                transactionItemRepo.save(transactionItemMapper.apiModelToEntity(transactionItem)));
    }

    public void deleteTransactionItemById(long transactionItemId) {
        transactionItemRepo.deleteById(transactionItemId);
    }

    public TransactionItem updateTransactionItem(TransactionItem transactionItem) {
        return transactionItemMapper.entityModelToApiModel(
                transactionItemRepo.save(transactionItemMapper.apiModelToEntity(transactionItem))
        );
    }

    public List<TransactionItem> getTransactionItemsByTransactionId(long transactionId) {
       List<TransactionItemEntity> transactionItemEntities
               = transactionItemRepo.getTransactionItemsByTransactionId(transactionId);
       return transactionItemMapper.entityListToApiModelList(transactionItemEntities);
    }
}
