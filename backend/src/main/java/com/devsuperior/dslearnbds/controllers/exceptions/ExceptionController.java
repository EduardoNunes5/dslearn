package com.devsuperior.dslearnbds.controllers.exceptions;

import com.devsuperior.dslearnbds.dto.CustomErrorResponse;
import com.devsuperior.dslearnbds.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {



    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CustomErrorResponse userNotFoundException(UserNotFoundException unfe){
        return new CustomErrorResponse(unfe.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException manve){
        BindingResult result = manve.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        return  new CustomErrorResponse(fieldErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public CustomErrorResponse badCredentialsException(BadCredentialsException bce){
        return new CustomErrorResponse("Usuário ou senha inválido!");
    }
}
