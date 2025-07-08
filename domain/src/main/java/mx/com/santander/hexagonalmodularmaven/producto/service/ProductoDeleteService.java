package mx.com.santander.hexagonalmodularmaven.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.exception.ProductoException;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoDeleteService {

    private final ProductoDao productoDao;
    private final ProductoRepository productoRepository;

    public void execute(Long id){
        if(productoDao.getById(id) == null){
            throw new ProductoException("El id a eliminar"+ id + " no existe");
        }
        productoRepository.deleteById(id);
    }

}
