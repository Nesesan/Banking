package com.nesesan.banking.services.impl;

import com.nesesan.banking.dto.AccountDto;
import com.nesesan.banking.exceptions.OperationNonPermittedException;
import com.nesesan.banking.models.Account;
import com.nesesan.banking.repositories.AccountRepository;
import com.nesesan.banking.services.AccountService;
import com.nesesan.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

   private final AccountRepository repository;
   private final ObjectsValidator<AccountDto> validator;

    @Override
    public int save(AccountDto dto) {
        // block account update -> iban cannot be changed
        if (dto.getId() != null) {
            throw new  OperationNonPermittedException(
                    "Account cannot be updated",
                    "save account",
                    "account",
                    "Update not permitted"
            );
        }
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        //generate random IBAN
        account.setIban(generateRandomIban());
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(int id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No account was found with the ID : " + id));

    }

    @Override
    public void delete(int id) {
        // todo check delete account
        repository.deleteById(id);

    }

    private String generateRandomIban() {
        //todo generate an iban
        String iban = Iban.random(CountryCode.FR).toFormattedString();

        // check if the iban already exists
        boolean ibanExists =  repository.findByIban(iban).isPresent();
        // if exists -> generate new random iban
        if (ibanExists) {
            generateRandomIban();
        }
        // if doesn't exist -> return generated iban
        return iban;
    }
}
