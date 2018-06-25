package com.example.ssn.services;

import com.example.ssn.contracts.User;

import javax.management.relation.Role;
import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User getUserById(Long id);

    User registration(String firstname, String lastname, Role role, String username, String password, String position);

    User resetPassword(Long id, String password);

    User changePassword(Long id, String password);

    User changeInfo();
}
