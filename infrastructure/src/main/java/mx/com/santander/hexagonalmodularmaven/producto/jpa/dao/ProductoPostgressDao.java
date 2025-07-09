package mx.com.santander.hexagonalmodularmaven.producto.jpa.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoDBMapper;
import mx.com.santander.hexagonalmodularmaven.producto.jpa.ProductoSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.model.exception.ProductoException;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;

@Repository
@RequiredArgsConstructor
public class ProductoPostgressDao implements ProductoDao{

    private final ProductoDBMapper productoDbMapper;
    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;

	@Override
    public Producto getById(Long id) {

        var optionalProducto = productoSpringJpaAdapterRepository.findById(id);

        if (optionalProducto.isEmpty()){
            throw new ProductoException(
                    String.format("Producto no encontrado", id));
        }

        return productoDbMapper.toDomain(optionalProducto.get());
    }

    @Override
    public List<Producto> getAll() {
        return productoSpringJpaAdapterRepository.findAll()
                .stream()
                .map(productoDbMapper::toDomain)
                .collect(Collectors.toList());
    }
}