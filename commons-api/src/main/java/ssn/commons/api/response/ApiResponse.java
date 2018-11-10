package ssn.commons.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private Object data;
    private ApiResponse.Status status = ApiResponse.Status.OK;
    private Type type;
    private List<ApiError> errors = null;
    private String authToken;

    protected ApiResponse(Object data) {
        setData(data);
    }

    public ApiResponse setData(Object data) {
        this.data = data;
        this.type = data == null ? Type.NONE : (isArray(data) || isCollection(data) ? Type.ARRAY : Type.OBJECT);
        return this;
    }

    public ApiResponse setErrors(List<ApiError> errors) {
        this.errors = new ArrayList<>();
        this.errors.addAll(errors);
        this.status = errors.isEmpty() ? Status.OK : Status.ERROR;
        return this;
    }

    public ApiResponse setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public ApiError getError() {
        if (errors == null || errors.isEmpty()) {
            return null;
        } else {
            return errors.get(0);
        }
    }


    public enum Status {
        OK,
        ERROR
    }

    public enum Type {
        NONE,
        OBJECT,
        ARRAY
    }

    private static boolean isArray(final Object obj) {
        return obj instanceof Object[] || obj instanceof boolean[] ||
                obj instanceof byte[] || obj instanceof short[] ||
                obj instanceof char[] || obj instanceof int[] ||
                obj instanceof long[] || obj instanceof float[] ||
                obj instanceof double[];
    }

    private static boolean isCollection(final Object obj) {
        return obj instanceof Iterable;
    }

}
