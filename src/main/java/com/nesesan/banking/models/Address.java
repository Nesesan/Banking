package com.nesesan.banking.models;

import com.nesesan.banking.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractEntity {

    private String street;

    private int houseNumber;

    private int zipCode;

    private String city;

    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
