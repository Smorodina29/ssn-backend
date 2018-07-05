package com.example.ssn.services;

import com.example.ssn.contracts.Group;
import com.example.ssn.contracts.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServicesImpl implements GroupService {
    @Override
    public List<Group> getGroups() {
        List<Group> groups = new ArrayList<Group>();
        groups.add(new Group("jwnfkjw"));

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
    public void addUsers(List<UserDto> userDtos) {

    }

    @Override
    public Group[] getGroupFromUser(long id) {
        return new Group[0];
    }
}
