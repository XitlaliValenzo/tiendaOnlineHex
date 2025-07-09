package mx.com.santander.hexagonalmodularmaven.producto.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.command.ProductoCreateHandler;
import mx.com.santander.hexagonalmodularmaven.producto.command.ProductoDeleteHandler;
import mx.com.santander.hexagonalmodularmaven.producto.command.ProductoUpdateHandler;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoCommandController {

    private final ProductoCreateHandler productoCreateHandler;
    private final ProductoUpdateHandler productoUpdateHandler;
    private final ProductoDeleteHandler productoDeleteHandler;

    @PostMapping()
    public ProductoDto create(@RequestBody ProductoCreateCommand productoCreateCommand) {
        return productoCreateHandler.execute(productoCreateCommand);
    }

    @PutMapping("/{id}")
    public ProductoDto update(@PathVariable Long id, @RequestBody ProductoUpdateCommand productoUpdateCommand) {
        return productoUpdateHandler.execute(productoUpdateCommand, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoDeleteHandler.execute(id);
    }

}
