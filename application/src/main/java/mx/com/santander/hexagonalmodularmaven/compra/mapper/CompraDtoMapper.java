package mx.com.santander.hexagonalmodularmaven.compra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.compra.model.dto.CompraDto;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;

@Mapper(componentModel = "spring")
@Component
public interface CompraDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "clienteId", target = "clienteId")
    @Mapping(source = "productos", target = "productos")
    @Mapping(source = "cantidad", target = "cantidad")
    @Mapping(source = "precioTotal", target = "precioTotal")
    @Mapping(source = "fechaCompra", target = "fechaCompra")
    CompraDto toDto(Compra domain);

}
