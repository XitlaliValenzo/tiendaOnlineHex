package mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

@Component
public class ProductoDBMapper {

    public ProductoEntity toDbo(Producto domain) {
        if (domain == null) {
            return null;
        }
        return new ProductoEntity(domain.getId(), domain.getNombre(), domain.getPrecio(), domain.getStock());
    }

    public Producto toDomain(ProductoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Producto(entity.getId(), entity.getNombre(), entity.getPrecio(), entity.getStock());
    }

    public ProductoEntity toDboCreate(Producto domain) {
        if (domain == null) {
            return null;
        }
        return new ProductoEntity(null, domain.getNombre(), domain.getPrecio(), domain.getStock());
    }

}
