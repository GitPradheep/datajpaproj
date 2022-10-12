package com.projectuser.datajpapro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetail> userNotFoundException(UserNotFoundException ex, WebRequest req){
        ErrorDetail error = new ErrorDetail(ex.getMessage(),"404",new Date());
        return new ResponseEntity<ErrorDetail>(error, HttpStatus.NOT_FOUND);
    }

}
