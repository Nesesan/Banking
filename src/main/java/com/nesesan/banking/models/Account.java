package com.nesesan.banking.models;

import com.nesesan.banking.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends AbstractEntity {

    private String Iban;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
