package mx.com.santander.hexagonalmodularmaven.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;

@RequiredArgsConstructor
public class ProductoByIdService {

    private final ProductoDao productoDao;

    public Producto execute(Long id){
        return productoDao.getById(id);
    }

}
