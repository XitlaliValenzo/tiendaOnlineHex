package mx.com.santander.hexagonalmodularmaven.productosCompra.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductosCompraDto {
    private Long productoId;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precioUnitario;
}
