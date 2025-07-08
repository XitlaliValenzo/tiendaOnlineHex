package mx.com.santander.hexagonalmodularmaven.producto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

@Mapper(componentModel = "spring")
@Component
public interface ProductoDtoMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "precio", target = "precio")
    @Mapping(source = "stock", target = "stock")
    ProductoDto toDto(Producto domain);
}
