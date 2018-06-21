package com.example.ssn;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.web.server.ServerHttpSecurity;

@RequiredArgsConstructor(access=AccessLevel.PROTECTED)
public class ApiError {
    private  String message;
    private int code;
    private HttpStatus httpStatus;
    private String field;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String trace;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    public ApiError(String message, int code, HttpStatus httpStatus, String field, String trace, Long id) {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
        this.field = field;
        this.trace = trace;
        this.id = id;
    }

    public ApiError() {
    }


    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getField() {
        return field;
    }

    public String getTrace() {
        return trace;
    }

    public Long getId() {
        return id;
    }

}
