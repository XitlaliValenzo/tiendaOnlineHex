package mx.com.santander.hexagonalmodularmaven.cliente.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}
