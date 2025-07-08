package mx.com.santander.hexagonalmodularmaven.producto.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;

@Component
@RequiredArgsConstructor
public class ProductoByIdHandler {

    private final ProductoDao productoDao;
    private final ProductoDtoMapper productoDtoMapper;

    public ProductoDto execute(Long id) {
        return productoDtoMapper.toDto(productoDao.getById(id));
    }
}
