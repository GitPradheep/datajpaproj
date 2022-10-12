package com.projectuser.datajpapro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserAlreadyExist extends RuntimeException{
    private String message;

    public UserAlreadyExist(){}
    public UserAlreadyExist(String msg){
        super(msg);
        this.message=msg;
    }
}
