package com.catalyst.assignment.exceptions.handler;

import com.catalyst.assignment.controllers.UserController;
import com.catalyst.assignment.exceptions.AppRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = UserController.class)
public class UserExceptionHandler {

    @ExceptionHandler(AppRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody RestError handleAppRuntimeException(AppRuntimeException e){
       return  new RestError(e.getErrorCode().getCode(),e.getErrorCode().getStatus().value(),e.getDescription());
    }
}
