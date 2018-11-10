package ssn.facades.exeptions;

public class UserAlreadyExistException extends BaseException {

    public UserAlreadyExistException() {
        super("User with this login already exist.");
    }
}
