package com.revature.quizzard.util;

import com.revature.quizzard.dtos.ErrorResponse;
import com.revature.quizzard.dtos.QuizzardHttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponseFactory {

    public ErrorResponse generateErrorResponse(int status, String message) {
        return new ErrorResponse(status, message, System.currentTimeMillis());
    }

    public ErrorResponse generateErrorResponse(QuizzardHttpStatus status) {
        return new ErrorResponse(status.getStatus(), status.toString(), System.currentTimeMillis());
    }

}
