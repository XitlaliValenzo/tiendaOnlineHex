package mx.com.santander.hexagonalmodularmaven.compra.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.santander.hexagonalmodularmaven.compra.model.exception.CompraException;

@ControllerAdvice
public class CompraControllerAdvice {

    @ExceptionHandler(CompraException.class)
    public ResponseEntity<String> handleEmtyInput(CompraException emptyInputException) {
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
}
