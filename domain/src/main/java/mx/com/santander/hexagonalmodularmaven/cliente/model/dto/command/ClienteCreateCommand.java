package mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteCreateCommand {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}
