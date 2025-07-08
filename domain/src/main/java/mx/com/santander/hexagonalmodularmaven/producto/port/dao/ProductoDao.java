package mx.com.santander.hexagonalmodularmaven.producto.port.dao;

import java.util.List;

import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

public interface ProductoDao {
    List<Producto> getAll();
    Producto getById(Long id);
}
