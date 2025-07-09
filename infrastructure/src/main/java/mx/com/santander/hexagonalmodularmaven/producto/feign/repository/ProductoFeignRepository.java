package mx.com.santander.hexagonalmodularmaven.producto.feign.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoDBMapper;
import mx.com.santander.hexagonalmodularmaven.producto.feign.ProductoFeignAdapter;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class ProductoFeignRepository implements ProductoRepository {

    private final ProductoFeignAdapter productoFeignAdapter;
    private final ProductoDBMapper productoDbMapper;

    @Override
    public Producto create(Producto producto) {
        var productoToSave = productoDbMapper.toDboCreate(producto);
        var productoSaved = productoFeignAdapter.create(productoToSave);
        return productoDbMapper.toDomain(productoSaved);
    }

    @Override
    public Producto update(Producto producto) {
        var productoToUpdate = productoDbMapper.toDbo(producto);
        var productoUpdated = productoFeignAdapter.update(producto.getId(), productoToUpdate);
        return productoDbMapper.toDomain(productoUpdated);
    }

    @Override
    public void deleteById(Long id) {
        productoFeignAdapter.delete(id);
    }

}
