package mx.com.santander.hexagonalmodularmaven.cliente.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteException extends RuntimeException {

    private String errorMessage;

    public ClienteException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
