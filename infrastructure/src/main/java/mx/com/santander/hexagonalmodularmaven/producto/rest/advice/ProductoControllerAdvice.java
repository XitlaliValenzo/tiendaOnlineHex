package mx.com.santander.hexagonalmodularmaven.producto.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.santander.hexagonalmodularmaven.producto.model.exception.ProductoException;

@ControllerAdvice
public class ProductoControllerAdvice {

    @ExceptionHandler(ProductoException.class)
    public ResponseEntity<String> handleEmtyInput(ProductoException emptyInputException) {
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

}
