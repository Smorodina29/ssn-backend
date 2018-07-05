package com.example.ssn.services;

import com.example.ssn.contracts.Group;
import com.example.ssn.contracts.UserDto;

import java.util.List;

public interface GroupService {
    List<Group> getGroups();
    Group createGroup(String name);
    void deleteGroup(long id);
    void addUsers(List<UserDto> userDtos);
    Group[] getGroupFromUser(long id);
}
