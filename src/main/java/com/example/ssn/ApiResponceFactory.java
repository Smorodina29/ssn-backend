package com.example.ssn;

import java.util.List;

public class ApiResponceFactory {
    private APIResponse success(){
        return success();
    }

    public static APIResponse success(Object obj){
        return new APIResponse(obj);
    }

    private APIResponse success(Object[] obj){
        return new APIResponse(obj);
    }

    private APIResponse faillure(){
        return faillure();
    }

    public APIResponse faillure(List<ApiError> errors){
        return faillure().setErrors(errors);
    }
}
