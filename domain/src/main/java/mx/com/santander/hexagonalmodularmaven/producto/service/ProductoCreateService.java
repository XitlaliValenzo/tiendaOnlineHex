package mx.com.santander.hexagonalmodularmaven.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoCreateService {

    private final ProductoRepository productoRepository;

    public Producto execute(ProductoCreateCommand productoCreateCommand){
        Producto productoToCreate = new Producto().requestToCreate(productoCreateCommand);
        return productoRepository.create(productoToCreate);
    }
}
