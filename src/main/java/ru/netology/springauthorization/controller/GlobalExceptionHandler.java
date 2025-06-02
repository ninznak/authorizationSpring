package ru.netology.springauthorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.springauthorization.exceptions.InvalidData;
import ru.netology.springauthorization.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidData.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials(InvalidData e) {
        return e.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println("Unauthorized user: " + e.getMessage());
        return e.getMessage();
    }
}