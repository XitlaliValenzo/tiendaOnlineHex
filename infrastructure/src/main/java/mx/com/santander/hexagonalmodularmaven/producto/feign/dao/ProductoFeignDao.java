package mx.com.santander.hexagonalmodularmaven.producto.feign.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoDBMapper;
import mx.com.santander.hexagonalmodularmaven.producto.feign.repository.ProductoFeignAdapter;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;

@Repository
@RequiredArgsConstructor
public class ProductoFeignDao implements ProductoDao{

    private final ProductoDBMapper productoDbMapper;
    private final ProductoFeignAdapter productoFeignAdapter;

	@Override
	public Producto getById(Long id) {
		final ProductoEntity productoEntity = productoFeignAdapter.getProducto(id);
		return productoDbMapper.toDomain(productoEntity);
	}

	@Override
	public List<Producto> getAll() {
		List<ProductoEntity> productos = productoFeignAdapter.getProductos();
		return productos.stream().map(productoDbMapper::toDomain).collect(Collectors.toList());
	}

}