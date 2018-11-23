package ssn.facades.services;


import ssn.facades.exeptions.AuthenticationFailedException;
import ssn.facades.model.UserFacade;

public interface UserService {
    UserFacade login(String login, String password) throws AuthenticationFailedException;
    /*List<UserDto> findAllUsers();

    UserDto getUserById(long id);

    UserDto registration(UserDto userDto);

    void resetPassword(long id, String password);

    void changePassword(long id, String password);

    UserDto changeInfo();

    UserDto delete(Long id);*/
}
