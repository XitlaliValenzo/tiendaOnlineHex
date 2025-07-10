package mx.com.santander.hexagonalmodularmaven.producto.model.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ProductoPrecio {
    private BigDecimal precio;
}
