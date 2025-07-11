package mx.com.santander.hexagonalmodularmaven.productosCompra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.productosCompra.model.dto.command.ProductosCompraCreateCommand;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosCompra {
    private Long id;
    private Long productoId;
    private Integer cantidad;
    private Compra compra;

    private Producto producto;

    public ProductosCompra requestToCreate(ProductosCompraCreateCommand p) {
        this.productoId = p.getProductoId();
        this.cantidad = p.getCantidad();
        return this;
    }

}
