package mx.com.santander.hexagonalmodularmaven.productosCompra.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductosCompraCreateCommand {
    private Long productoId;
    private Integer cantidad;
}
