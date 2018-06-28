package com.example.ssn.services;

import com.example.ssn.contracts.Roles;
import com.example.ssn.contracts.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User getUserById(long id);

    User registration(String firstname, String lastname, Roles role, String username, String password, String position);

    void resetPassword(long id, String password);

    void changePassword(long id, String password);

    User changeInfo();

    User delete(long id);
}
