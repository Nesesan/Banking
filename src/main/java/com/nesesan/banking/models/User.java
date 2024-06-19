package com.nesesan.banking.models;

import com.nesesan.banking.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User extends AbstractEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean active;

    //private Address address;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;

    @OneToOne
    private Account account;

    @OneToOne

    private Address address;

    @OneToOne
    private Role role;

}
