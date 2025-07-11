package mx.com.santander.hexagonalmodularmaven.compra.adapter.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.compra.adapter.entity.CompraEntity;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;
import mx.com.santander.hexagonalmodularmaven.productosCompra.adapter.entity.ProductosCompraEntity;
import mx.com.santander.hexagonalmodularmaven.productosCompra.adapter.mapper.ProductosCompraDBMapper;

@Component
@RequiredArgsConstructor
public class CompraDBMapper {

    private final ProductosCompraDBMapper productosCompraDBMapper;

    public CompraEntity toDboCreate(Compra domain){
        
        if(domain == null){
            return null;
        }
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setClienteId(domain.getClienteId());
        compraEntity.setFechaCompra(domain.getFechaCompra());
        compraEntity.setPrecioTotal(domain.getPrecioTotal());

        compraEntity.setProductos(domain.getProductos().stream().map(p -> {
            ProductosCompraEntity productosCompraEntity = productosCompraDBMapper.toDbo(p);
            productosCompraEntity.setCompra(compraEntity);
            return productosCompraEntity;
        }).collect(Collectors.toList()));
        return compraEntity;
    }

    public Compra toDomain(CompraEntity entity){
        if(entity == null){
            return null;
        }
        return new Compra(
            entity.getId(), 
            entity.getClienteId(), 
            entity.getProductos().stream().map(productosCompraDBMapper::toDomain).collect(Collectors.toList()), 
            entity.getPrecioTotal(), 
            entity.getFechaCompra());
    }

}
