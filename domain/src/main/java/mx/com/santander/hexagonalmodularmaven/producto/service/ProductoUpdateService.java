package mx.com.santander.hexagonalmodularmaven.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.model.exception.ProductoException;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoUpdateService {

    private final ProductoDao productoDao;
    private final ProductoRepository productoRepository;

    public Producto execute(ProductoUpdateCommand productoUpdateCommand, Long id){
        Producto productoToUpdate = productoDao.getById(id);
        if(productoToUpdate == null){
            throw new ProductoException("El id a eliminar"+ id + " no existe");
        } 
        productoToUpdate.requestToUpdate(productoUpdateCommand);
        return productoRepository.update(productoToUpdate);   
    }

}
