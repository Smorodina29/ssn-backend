package ssn.commons.api.error;

import ssn.commons.api.response.ApiResponse;
import ssn.commons.api.response.ApiResponseFactory;

public class Errors {
    public static final ApiResponse NO_USER_WITH_LOGIN_OR_PASSWORD = ApiResponseFactory.failure("There is no user with such login or password.", 1);
    public static final ApiResponse UNKNOWN_ERROR = ApiResponseFactory.failure("unknown.", 1000);
    public static final ApiResponse ENTITY_NOT_FOUND = ApiResponseFactory.failure("Entity not found.", 1004);
    public static final ApiResponse INVALID_FIELD_VALUE = ApiResponseFactory.failure("Request field is incorrect", 1005);
    public static final ApiResponse REQUEST_FIELD_EMPTY = ApiResponseFactory.failure("Request field is empty", 1006);
    public static final ApiResponse TOKEN_REQUIRED = ApiResponseFactory.failure("Token required for this method.", 3);
    public static final ApiResponse BAD_TOKEN = ApiResponseFactory.failure("Bad auth token", 6);
    public static final ApiResponse TOKEN_EXPIRED = ApiResponseFactory.failure("Auth token expired", 7);
    public static final ApiResponse JSON_UNRECOGNIZED_PROPERTY = ApiResponseFactory.failure("Unrecognized property.", 8);
    public static final ApiResponse USER_WITH_LOGIN_ALREADY_EXIST = ApiResponseFactory.failure("User with this email already exist.", 9);


}
