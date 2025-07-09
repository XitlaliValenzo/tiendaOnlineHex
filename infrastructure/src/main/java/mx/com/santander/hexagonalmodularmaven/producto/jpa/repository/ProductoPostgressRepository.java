package mx.com.santander.hexagonalmodularmaven.producto.jpa.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoDBMapper;
import mx.com.santander.hexagonalmodularmaven.producto.jpa.ProductoSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class ProductoPostgressRepository implements ProductoRepository {

    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;
    private final ProductoDBMapper productoDbMapper;

    @Override
    public Producto create(Producto producto) {
        var productoToSave = productoDbMapper.toDboCreate(producto);
        var productoSaved = productoSpringJpaAdapterRepository.save(productoToSave);
        return productoDbMapper.toDomain(productoSaved);
    }

    @Override
    public void deleteById(Long id) {
        productoSpringJpaAdapterRepository.deleteById(id);
    }

    @Override
    public Producto update(Producto producto) {
        var productoToUpdate = productoDbMapper.toDbo(producto);
        var productoUpdated = productoSpringJpaAdapterRepository.save(productoToUpdate);
        return productoDbMapper.toDomain(productoUpdated);
    }

}
