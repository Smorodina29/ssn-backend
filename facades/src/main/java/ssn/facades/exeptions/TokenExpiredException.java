package ssn.facades.exeptions;

import ssn.facades.exeptions.BaseException;

public class TokenExpiredException extends BaseException {

    protected TokenExpiredException(String message) {
        super(message);
    }

    public static TokenExpiredException wrongUserId() {
        return new TokenExpiredException("Token expired because user was removed.");
    }

    public static TokenExpiredException wrongApplicationId() {
        return new TokenExpiredException("Token expired because application was removed.");
    }

    public static TokenExpiredException criticalDataChanged() {
        return new TokenExpiredException("Token expired because user has changed critical data.");
    }

    public static TokenExpiredException outdated() {
        return new TokenExpiredException("Token expired because it is outdated.");
    }
}
