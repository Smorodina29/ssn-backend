package com.example.ssn.services;

import com.example.ssn.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl implements UserService {
    @Override
    public List<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1l, "Bob", "Marly", "ragga1976", "pass", "doggy"));
        return users;
    }
}
