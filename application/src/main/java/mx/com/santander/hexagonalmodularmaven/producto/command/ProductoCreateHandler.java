package mx.com.santander.hexagonalmodularmaven.producto.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoCreateService;

@Component
@RequiredArgsConstructor
public class ProductoCreateHandler {

    private final ProductoCreateService productoCreateService;
    private final ProductoDtoMapper productoDtoMapper;

    public ProductoDto execute(ProductoCreateCommand productoCreateCommand){
        return productoDtoMapper.toDto(productoCreateService.execute(productoCreateCommand));
    }

}
