package mx.com.santander.hexagonalmodularmaven.producto.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.mapper.ProductoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;

@Component
@RequiredArgsConstructor
public class ProductoGetAllHandler {

    private final ProductoDao productoDao;
    private final ProductoDtoMapper productoDtoMapper;

    public List<ProductoDto> execute(){
        return productoDao.getAll()
            .stream()
            .map(productoDtoMapper::toDto)
            .collect(Collectors.toList());
    }
}