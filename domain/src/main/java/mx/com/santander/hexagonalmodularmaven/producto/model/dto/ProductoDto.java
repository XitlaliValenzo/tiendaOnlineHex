package mx.com.santander.hexagonalmodularmaven.producto.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDto {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
}
