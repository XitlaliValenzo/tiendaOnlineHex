package mx.com.santander.hexagonalmodularmaven.producto.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoException extends RuntimeException {

    private String errorMessage;

    public ProductoException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
