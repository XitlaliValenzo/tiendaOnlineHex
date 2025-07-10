package mx.com.santander.hexagonalmodularmaven.compra.adapter.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private List<Producto> productos;
    private Integer cantidad;
    private BigDecimal precioTotal;
    private Date fechaCompra;

}
