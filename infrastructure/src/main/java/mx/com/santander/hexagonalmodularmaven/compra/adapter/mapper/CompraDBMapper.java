package mx.com.santander.hexagonalmodularmaven.compra.adapter.mapper;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.compra.adapter.entity.CompraEntity;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;

@Component
public class CompraDBMapper {

    public CompraEntity toDboCreate(Compra domain){
        if(domain == null){
            return null;
        }
        return new CompraEntity(null, domain.getClienteId(), domain.getProductos(), domain.getCantidad(), domain.getPrecioTotal(), domain.getFechaCompra());
    }

    public Compra toDomain(CompraEntity entity){
        if(entity == null){
            return null;
        }
        return new Compra(entity.getId(), entity.getClienteId(), entity.getProductos(), entity.getCantidad(), entity.getPrecioTotal(), entity.getFechaCompra());
    }

}
