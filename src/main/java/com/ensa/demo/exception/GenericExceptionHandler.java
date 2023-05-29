package com.ensa.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler(value = ElementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleElementNotFoundException(ElementNotFoundException elementNotFoundException) {
        return new ResponseEntity<>(ErrorResponse.
                builder().
                status(HttpStatus.NOT_FOUND.value()).
                message("element not found").
                build(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value= ElementAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleElementAlreadyExistsException (ElementAlreadyExistsException elementAlreadyExistsException){
        return new ResponseEntity<>(ErrorResponse
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("already existed element")
                .build()
        ,HttpStatus.BAD_REQUEST) ;
    }
    @ExceptionHandler(value= NotConductorAvaibleException.class)
    public ResponseEntity<ErrorResponse> handleNotConductorAvaibleException (NotConductorAvaibleException notConductorAvaibleException){
        return new ResponseEntity<>(ErrorResponse
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("not conductor avialable in this date")
                .build()
                ,HttpStatus.BAD_REQUEST) ;
    }
    @ExceptionHandler(value= NotVehiculeAvaibleException.class)
    public ResponseEntity<ErrorResponse> handleNotVehiculeAvaibleException (NotVehiculeAvaibleException notVehiculeAvaibleException){
        return new ResponseEntity<>(ErrorResponse
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("not vehicule avialable in this date")
                .build()
                ,HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(value= NotComfermityException.class)
    public ResponseEntity<ErrorResponse> handleNotComfermityException (NotComfermityException notComfermityException){
        return new ResponseEntity<>(ErrorResponse
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("not confermity exception")
                .build()
                ,HttpStatus.BAD_REQUEST) ;
    }

}
