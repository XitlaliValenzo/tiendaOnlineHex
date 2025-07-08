package mx.com.santander.hexagonalmodularmaven.producto.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;

@RequiredArgsConstructor
public class ProductoGetAllService {

    private final ProductoDao productoDao;

    public List<Producto> execute(){
        return productoDao.getAll();
    }
}
