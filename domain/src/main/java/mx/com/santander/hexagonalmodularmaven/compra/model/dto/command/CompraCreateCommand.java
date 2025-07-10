package mx.com.santander.hexagonalmodularmaven.compra.model.dto.command;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraCreateCommand {

    private Long clienteId;
    private List<Producto> productos;
    private Integer cantidad;
    private BigDecimal precioTotal;
    private Date fechaCompra;

}
