package com.nesesan.banking.dto;

import com.nesesan.banking.models.Transaction;
import com.nesesan.banking.models.TransactionType;
import com.nesesan.banking.models.User;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionDto {

    private int id;

    @Positive
    @Max(value = 1000000)
    @Min(value = 10)
    private BigDecimal amount;

    private TransactionType type;

    private String destinationIban;

    private int userId;


    public static TransactionDto fromTransaction(Transaction transaction) {
        return TransactionDto.builder()
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .destinationIban(transaction.getDestinationIban())
                .userId(transaction.getUser().getId())
                .build();
    }

    public static Transaction toTransaction(TransactionDto transaction) {
        return Transaction.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .destinationIban(transaction.getDestinationIban())
                .user(
                        User.builder()
                                .id(transaction.getUserId())
                                .build()
                )
                .build();
    }
}
