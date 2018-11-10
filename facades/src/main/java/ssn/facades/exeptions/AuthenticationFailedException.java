package ssn.facades.exeptions;

import ssn.facades.exeptions.BaseException;

public class AuthenticationFailedException extends BaseException {
    public AuthenticationFailedException(String reason) {
        super("Authentication failed: " + reason);
    }
}
