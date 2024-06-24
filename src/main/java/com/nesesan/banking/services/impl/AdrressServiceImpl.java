package com.nesesan.banking.services.impl;

import com.nesesan.banking.dto.AddressDto;
import com.nesesan.banking.models.Address;
import com.nesesan.banking.repositories.AddressRepository;
import com.nesesan.banking.services.AddressService;
import com.nesesan.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdrressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final ObjectsValidator<AddressDto> validator;

    @Override
    public int save(AddressDto dto) {
        validator.validate(dto);
        Address address = AddressDto.toEntity(dto);
        return repository.save(address).getId();
    }

    @Override
    public List<AddressDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AddressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(int id) {
        return repository.findById(id)
                .map(AddressDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No address found with this ID : " + id));
    }

    @Override
    public void delete(int id) {
        // todo check delete
        repository.deleteById(id);
    }
}
