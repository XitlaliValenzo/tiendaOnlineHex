package mx.com.santander.hexagonalmodularmaven.producto.model.entity;

import java.math.BigDecimal;

import lombok.NoArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;

@NoArgsConstructor
public class Producto {
    private ProductoId id;
    private ProductoNombre nombre;
    private ProductoPrecio precio;
    private ProductoStock stock;

    public Producto(Long id, String nombre, BigDecimal precio, Integer stock) {
        this.id = new ProductoId(id);
        this.nombre = new ProductoNombre(nombre);
        this.precio = new ProductoPrecio(precio);
        this.stock = new ProductoStock(stock);
    }

    public Producto requestToCreate(ProductoCreateCommand productoCreateCommand){
        this.nombre = new ProductoNombre(productoCreateCommand.getNombre());
        this.precio = new ProductoPrecio(productoCreateCommand.getPrecio());
        this.stock = new ProductoStock(productoCreateCommand.getStock());
        return this;
    }

    public Producto requestToUpdate(ProductoUpdateCommand productoUpdateCommand){
        this.nombre = new ProductoNombre(productoUpdateCommand.getNombre());
        this.precio = new ProductoPrecio(productoUpdateCommand.getPrecio());
        this.stock = new ProductoStock(productoUpdateCommand.getStock());
        return this;
    }

    public Long getId(){
        return id.getId();
    }

    public String getNombre(){
        return nombre.getNombre();
    }

    public BigDecimal getPrecio(){
        return precio.getPrecio();
    }

    public Integer getStock(){
        return stock.getStock();
    }

}
