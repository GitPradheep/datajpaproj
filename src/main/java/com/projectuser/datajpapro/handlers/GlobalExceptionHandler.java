package com.projectuser.datajpapro.handlers;
import com.projectuser.datajpapro.exception.ErrorDetail;
import com.projectuser.datajpapro.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetail> userNotFoundException(UserNotFoundException ex, WebRequest req){
        ErrorDetail error = new ErrorDetail(ex.getMessage(),"404",new Date());
        return new ResponseEntity<ErrorDetail>(error, HttpStatus.NOT_FOUND);
    }

}
