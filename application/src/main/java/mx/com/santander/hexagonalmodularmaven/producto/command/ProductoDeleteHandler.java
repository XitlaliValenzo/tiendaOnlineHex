package mx.com.santander.hexagonalmodularmaven.producto.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoDeleteService;

@Component
@RequiredArgsConstructor
public class ProductoDeleteHandler {

    private final ProductoDeleteService productoDeleteService;

    public void execute(Long id){
        productoDeleteService.execute(id);
    }
}
