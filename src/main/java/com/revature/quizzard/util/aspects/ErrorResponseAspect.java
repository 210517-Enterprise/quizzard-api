package com.revature.quizzard.util.aspects;

import com.revature.quizzard.dtos.ErrorResponse;
import com.revature.quizzard.dtos.QuizzardHttpStatus;
import com.revature.quizzard.util.exceptions.*;
import com.revature.quizzard.util.ErrorResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class ErrorResponseAspect {

    private ErrorResponseFactory errRespFactory;

    @Autowired
    public ErrorResponseAspect(ErrorResponseFactory errRespFactory) {
        this.errRespFactory = errRespFactory;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(InvalidRequestException e) {
        return errRespFactory.generateErrorResponse(QuizzardHttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        return errRespFactory.generateErrorResponse(QuizzardHttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleResourcePersistenceException(ResourcePersistenceException e) {
        return errRespFactory.generateErrorResponse(QuizzardHttpStatus.CONFLICT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleAuthenticationException(AuthenticationException e) {
        return errRespFactory.generateErrorResponse(QuizzardHttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleAuthorizationException(AuthorizationException e) {
        return errRespFactory.generateErrorResponse(QuizzardHttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleQuizzardException(QuizzardException e) {
        return errRespFactory.generateErrorResponse(QuizzardHttpStatus.INTERNAL_SERVER_ERROR);
    }

}
