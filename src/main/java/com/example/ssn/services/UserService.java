package com.example.ssn.services;

import com.example.ssn.contracts.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();

    UserDto getUserById(long id);

    UserDto registration(UserDto userDto);

    void resetPassword(long id, String password);

    void changePassword(long id, String password);

    UserDto changeInfo();

    UserDto delete(Long id);
}
