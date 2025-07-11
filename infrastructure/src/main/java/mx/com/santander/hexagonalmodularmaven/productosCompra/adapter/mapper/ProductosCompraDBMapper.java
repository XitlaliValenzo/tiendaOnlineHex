package mx.com.santander.hexagonalmodularmaven.productosCompra.adapter.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.productosCompra.adapter.entity.ProductosCompraEntity;
import mx.com.santander.hexagonalmodularmaven.productosCompra.model.entity.ProductosCompra;

@Component
@RequiredArgsConstructor
public class ProductosCompraDBMapper {

    private final ProductoDao productoDao;

    public ProductosCompraEntity toDbo(ProductosCompra domain) {
        if (domain == null) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();
        if (domain.getProducto() != null) {
            productoEntity.setId(domain.getProducto().getId());
            productoEntity.setNombre(domain.getProducto().getNombre());
            productoEntity.setPrecio(domain.getProducto().getPrecio());
            productoEntity.setStock(domain.getProducto().getStock());
        } else {
            productoEntity.setId(domain.getProductoId());
        }
        
        return new ProductosCompraEntity(null, productoEntity, domain.getCantidad(), null);
    }

    public ProductosCompra toDomain(ProductosCompraEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductosCompra productosCompra = new ProductosCompra();
        productosCompra.setId(entity.getId());
        productosCompra.setProductoId(entity.getProducto().getId());
        productosCompra.setCantidad(entity.getCantidad());

        Producto producto = productoDao.getById(entity.getProducto().getId());
        productosCompra.setProducto(producto);

        return productosCompra;
    }

}
