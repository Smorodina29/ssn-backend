package ssn.web.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {
    private String login;

    private String password;
}
