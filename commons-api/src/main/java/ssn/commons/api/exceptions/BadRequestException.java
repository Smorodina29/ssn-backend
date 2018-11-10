package ssn.commons.api.exceptions;

import ssn.commons.api.response.ApiResponse;
import ssn.facades.exeptions.BaseException;

public class BadRequestException extends BaseException {
    private final ApiResponse apiResponse;

    public BadRequestException(ApiResponse errorResponseDto) {
        this.apiResponse = errorResponseDto;
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
