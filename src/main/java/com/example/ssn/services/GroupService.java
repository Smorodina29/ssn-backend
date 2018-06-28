package com.example.ssn.services;

import com.example.ssn.contracts.Group;
import com.example.ssn.contracts.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GroupService {
    List<Group> getGroups();
    Group createGroup(String name);
    void deleteGroup(long id);
    void addUsers(List<User> users);
    Group[] getGroupFromUser(long id);
}
