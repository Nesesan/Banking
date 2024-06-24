package com.nesesan.banking.repositories;

import com.nesesan.banking.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
