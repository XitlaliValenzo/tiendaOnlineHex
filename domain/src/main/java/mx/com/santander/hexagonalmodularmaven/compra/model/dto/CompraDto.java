package mx.com.santander.hexagonalmodularmaven.compra.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.productosCompra.model.dto.ProductosCompraDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraDto {
    private Long id;
    private Long clienteId;
    private List<ProductosCompraDto> productos;
    private BigDecimal precioTotal;
    private Date fechaCompra;

}
