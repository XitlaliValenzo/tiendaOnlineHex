package mx.com.santander.hexagonalmodularmaven.compra.model.dto.command;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.productosCompra.model.dto.command.ProductosCompraCreateCommand;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraCreateCommand {

    private Long clienteId;
    private List<ProductosCompraCreateCommand> productos;
}
