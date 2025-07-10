package mx.com.santander.hexagonalmodularmaven.compra.model.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CompraProductos {
    private List<Producto> productos;
}
