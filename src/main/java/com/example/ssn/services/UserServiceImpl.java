package com.example.ssn.services;

import com.example.ssn.contracts.Group;
import com.example.ssn.contracts.Roles;
import com.example.ssn.contracts.User;
import com.example.ssn.exeptions.NotFoundUser;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Bob", "Marli", new Roles("user"),  "bobm", "pass123", "operator"));
        //users.add(new User(12, "Steve", "Marli", new Roles("user"),  new Group[1], "bobm", "pass123", "operator"));
        return users;
    }

    @Override
    public User getUserById(long id) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Bob", "Marli", new Roles("user"),"bobm", "pass123", "operator"));
        users.add(new User((long)12, "Steve", "Marli", new Roles("user"),"bobm", "pass123", "operator"));

        for (User user : users) {
            if (Objects.equals(user.getId(), id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User registration(String firstname, String lastname, Roles role, String username, String password, String position) {
        List<User> arrayList = new ArrayList<>();
        User user = new User(firstname,lastname, role, username, password, position);
        System.out.println(user.getUsername());
        System.out.println(username);
        arrayList.add(user);
        return user;
    }

    @Override
    public User resetPassword(long id, String password) {
        return null;
    }

    @Override
    public User changePassword(long id, String password) {
        return null;
    }


    @Override
    public User changeInfo() {
        return null;
    }
}
