package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(UserIdException.class)
    public ResponseEntity<UserErrorResponse> handleIdException(UserIdException err) {
        return buildErrorResponse("ID " + err.getMessage() + " is invalid.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<UserErrorResponse> handleNameException(UserNameException err) {
        return buildErrorResponse("USERNAME " + err.getMessage() + " is invalid.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CPFException.class)
    public ResponseEntity<UserErrorResponse> handleCPFException(CPFException err) {
        return buildErrorResponse("CPF " + err.getMessage() + " is invalid.", HttpStatus.BAD_REQUEST);
    }

    /**
     * Método auxiliar para construir a resposta de erro padronizada.
     */
    private ResponseEntity<UserErrorResponse> buildErrorResponse(String message, HttpStatus status) {
        UserErrorResponse errorResponse = new UserErrorResponse(status.value(), message);
        return new ResponseEntity<>(errorResponse, status);
    }
}