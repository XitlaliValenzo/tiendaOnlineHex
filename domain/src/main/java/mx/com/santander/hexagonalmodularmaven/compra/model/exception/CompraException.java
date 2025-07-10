package mx.com.santander.hexagonalmodularmaven.compra.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraException extends RuntimeException{

    private String errorMessage;

    public CompraException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
