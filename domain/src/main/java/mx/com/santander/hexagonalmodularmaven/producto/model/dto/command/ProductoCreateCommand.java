package mx.com.santander.hexagonalmodularmaven.producto.model.dto.command;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoCreateCommand {
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
}
