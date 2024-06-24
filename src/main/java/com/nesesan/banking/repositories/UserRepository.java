package com.nesesan.banking.repositories;

import com.nesesan.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
