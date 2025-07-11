package mx.com.santander.hexagonalmodularmaven.compra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.compra.model.dto.CompraDto;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;
import mx.com.santander.hexagonalmodularmaven.productosCompras.mapper.ProductosComprasDtoMapper;

@Mapper(componentModel = "spring", uses = { ProductosComprasDtoMapper.class })
@Component
public interface CompraDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "clienteId", target = "clienteId")
    @Mapping(source = "productos", target = "productos")
    @Mapping(source = "precioTotal", target = "precioTotal")
    @Mapping(source = "fechaCompra", target = "fechaCompra", dateFormat = "dd/MM/yyyy HH:mm:ss")
    CompraDto toDto(Compra domain);

}
