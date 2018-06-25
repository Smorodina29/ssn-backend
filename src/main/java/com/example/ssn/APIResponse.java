package com.example.ssn;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse {
    private Object data;
    private APIResponse.Status status = APIResponse.Status.OK;
    private Type type;
    private List<ApiError> errors;
    private String authToken;

    protected APIResponse(Object obj){
        setData(obj);
    }

    public Object getData() {
        return data;
    }

    private  void setData(Object data) {
        this.data = data;
        if (data==null){
            this.type = Type.NONE;
        }
        else if (isArray(data)||isCollecion(data)){
            this.type = Type.ARRAY;
        }
        else this.type = Type.OBJECT;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<ApiError> getErrors() {
        return errors;
    }

    private ApiError getError(){
        if(errors==null || errors.isEmpty()) return null;
        else return  errors.get(0);
    }

    private APIResponse setErrors(List<ApiError> errors) {
        this.errors = new ArrayList<>();
        this.errors.addAll(errors);
        this.status = errors.isEmpty() ? Status.OK : Status.ERROR;
        return this;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public APIResponse() {
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

    private static boolean isArray(final Object obj){
        return obj instanceof Object[] || obj instanceof boolean[] || obj instanceof  byte[] ||
                obj instanceof char[] || obj instanceof int[] || obj instanceof long[] ||
                obj instanceof float[] || obj instanceof double[];
     }

     private static boolean isCollecion(final Object obj){
        return  obj instanceof Iterable;
     }
}
