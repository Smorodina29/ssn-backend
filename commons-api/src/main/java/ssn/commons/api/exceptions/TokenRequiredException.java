package ssn.commons.api.exceptions;

import ssn.facades.exeptions.BaseException;

public class TokenRequiredException extends BaseException {
    public TokenRequiredException(String headerName) {
        super("Headers does not contain '" + headerName + "'.");
    }
}
