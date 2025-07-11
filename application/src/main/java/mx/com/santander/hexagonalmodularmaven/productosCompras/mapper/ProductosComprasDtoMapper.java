package mx.com.santander.hexagonalmodularmaven.productosCompras.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.productosCompra.model.dto.ProductosCompraDto;
import mx.com.santander.hexagonalmodularmaven.productosCompra.model.entity.ProductosCompra;

@Mapper(componentModel = "spring")
@Component
public interface ProductosComprasDtoMapper {

    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "producto.nombre", target = "nombre")
    @Mapping(source = "producto.precio", target = "precioUnitario")
    ProductosCompraDto toDto(ProductosCompra domain);
}
