package mx.com.santander.hexagonalmodularmaven.compra.model.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CompraPrecioTotal {
    private BigDecimal precioTotal;
}
