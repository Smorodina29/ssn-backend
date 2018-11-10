package ssn.commons.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiError {
    private final String message;
    private final int code;
    private final HttpStatus httpStatus;
    private final String field;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String trace;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long deviceId;
}
