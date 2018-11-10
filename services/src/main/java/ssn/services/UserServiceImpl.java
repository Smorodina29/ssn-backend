package ssn.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    /*@Override
    public List<UserDto> findAllUsers() {
        ArrayList<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto("Bob", "Marli", Roles.USER,  "bobm", "pass123", "operator"));
        //userDtos.add(new UserDto(12, "Steve", "Marli", new Roles("user"),  new Group[1], "bobm", "pass123", "operator"));
        return userDtos;
    }

    @Override
    public UserDto getUserById(long id) {
        ArrayList<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto("Bob", "Marli", Roles.USER,"bobm", "pass123", "operator"));
        userDtos.add(new UserDto((long)12, "Steve", "Marli", Roles.USER,"bobm", "pass123", "operator"));

        for (UserDto userDto : userDtos) {
            if (Objects.equals(userDto.getId(), id)){
                return userDto;
            }
        }
        return null;
    }

    @Override
    public UserDto registration(UserDto userDto) {
        List<UserDto> arrayList = new ArrayList<>();
        arrayList.add(userDto);
        return arrayList.get(0);
    }

    @Override
    public void resetPassword(long id, String password) {

    }

    @Override
    public void changePassword(long id, String password) {

    }


    @Override
    public UserDto changeInfo() {
        return null;
    }

    @Override
    public UserDto delete(Long id) {
        int i = 0;
        ArrayList<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto((long)5,"Bob", "Marli", Roles.USER,"bobm", "pass123", "operator"));
        userDtos.add(new UserDto((long)12, "Steve", "Marli", Roles.USER,"bobm", "pass123", "operator"));

        for (int j = 0; j< userDtos.size(); j++) {
            if (userDtos.get(j).getId().equals(id)){
               i = j;
            }
        }
        userDtos.remove(i);
        return null;
    }*/
}
