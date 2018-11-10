package ssn.commons.api.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiResponseFactory {

    public static ApiResponse success() {
        return success(null);
    }

    public static ApiResponse success(final Object payload) {
        return new ApiResponse(payload);
    }

    private static ApiResponse failure() {
        return new ApiResponse(null);
    }

    public static ApiResponse failure(final List<ApiError> reasons) {
        return failure().setErrors(reasons);
    }

    public static ApiResponse failure(final ApiError... reasons) {
        return failure().setErrors(Arrays.asList(reasons));
    }

    public static ApiResponse failure(final BindingResult bindingResult) {
        final List<ApiError> errors = bindingResult
                .getFieldErrors()
                .stream()
                .map(e -> ApiError.builder()
                        .message(e.getDefaultMessage())
                        .code(ValidationErrorCodes.valueOrDefault(e.getCode()).getCode())
                        .field(e.getField())
                        .build())
                .collect(Collectors.toList());

        return failure(errors);
    }

    public static ApiResponse failure(final String message, final int code) {
        return failure(ApiError.builder().message(message).code(code).build());
    }

    public static ApiResponse failure(final String message, final String trace) {
        return failure(ApiError.builder().message(message).trace(trace).build());
    }

    public static ApiResponse failure(final String message, final int code, final String field) {
        return failure(ApiError
                .builder()
                .message(message)
                .code(code)
                .field(field)
                .build());
    }
}
