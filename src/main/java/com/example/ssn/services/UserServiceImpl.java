package com.example.ssn.services;

import com.example.ssn.contracts.Group;
import com.example.ssn.contracts.Roles;
import com.example.ssn.contracts.User;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Bob", "Marli", new Roles("user"),  new Group[1], "bobm", "pass123", "operator"));
        return users;
    }

    @Override
    public User getUserById(Long id) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Bob", "Marli", new Roles("user"),  new Group[1], "bobm", "pass123", "operator"));
        return users.get(id.intValue());
    }

    @Override
    public User registration(String firstname, String lastname, Role role, String username, String password, String position) {
        return new User("Bob", "Marli", new Roles("user"),  new Group[1], "bobm", "pass123", "operator");
    }

    @Override
    public User resetPassword(Long id, String password) {
        return null;
    }

    @Override
    public User changePassword(Long id, String password) {
        return null;
    }


    @Override
    public User changeInfo() {
        return null;
    }
}
