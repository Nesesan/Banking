package com.nesesan.banking.services;

import com.nesesan.banking.dto.TransactionDto;
import com.nesesan.banking.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionService extends AbstractService<TransactionDto> {
}
