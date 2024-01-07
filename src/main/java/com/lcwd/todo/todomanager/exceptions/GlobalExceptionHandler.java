package com.lcwd.todo.todomanager.exceptions;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //we are created handler method for specific exception
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException ex){
        logger.info("Its Null Pointer Exception from global handler");
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //handling resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourseNotFoundException(ResourceNotFoundException ex){
        logger.info("Its is a custom exception");
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage() , false ,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException ex){
        logger.info("Runtime Exception");
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage() , false ,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
