package com.example.ssn.repositories;

import com.example.ssn.contracts.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositories extends CrudRepository<User, Long> {
}
