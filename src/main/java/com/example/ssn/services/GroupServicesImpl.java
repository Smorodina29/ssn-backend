package com.example.ssn.services;

import com.example.ssn.contracts.Group;
import com.example.ssn.contracts.User;

import java.util.List;

public class GroupServicesImpl implements GroupService {
    @Override
    public Group[] getGroups() {
        Group group = new Group("jwnfkjw");
        Group[] groups = new Group[1];
        groups[0] = group;

        return groups;
    }

    @Override
    public Group createGroup(String name) {
        return null;
    }

    @Override
    public void deleteGroup(long id) {

    }

    @Override
    public void addUsers(List<User> users) {

    }

    @Override
    public Group[] getGroupFromUser(long id) {
        return new Group[0];
    }
}
