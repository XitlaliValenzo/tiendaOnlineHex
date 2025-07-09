package mx.com.santander.hexagonalmodularmaven.cliente.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.santander.hexagonalmodularmaven.cliente.model.exception.ClienteException;

@ControllerAdvice
public class ClienteControllerAdvice {

    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<String> handleEmtyInput(ClienteException emptyInputException) {
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

}
