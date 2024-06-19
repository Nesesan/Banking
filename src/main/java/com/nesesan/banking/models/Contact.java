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
public class Contact extends AbstractEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String iban;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
