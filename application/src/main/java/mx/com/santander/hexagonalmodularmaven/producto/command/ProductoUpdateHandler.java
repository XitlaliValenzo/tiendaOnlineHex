package mx.com.santander.hexagonalmodularmaven.producto.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoUpdateService;

@Component
@RequiredArgsConstructor
public class ProductoUpdateHandler {

    private final ProductoUpdateService productoUpdateSeervice;
    private final ProductoDtoMapper productoDtoMapper;

    public ProductoDto execute(ProductoUpdateCommand productoUpdateCommand, Long id) {
        return productoDtoMapper.toDto(productoUpdateSeervice.execute(productoUpdateCommand, id));
    }
}
