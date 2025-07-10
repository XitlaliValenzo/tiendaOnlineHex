package mx.com.santander.hexagonalmodularmaven.compra.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.NoArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.command.CompraCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

@NoArgsConstructor
public class Compra {
    private CompraId id;
    private CompraClienteId clienteId;
    private CompraProductos productos;
    private CompraCantidad cantidad;
    private CompraPrecioTotal precioTotal;
    private CompraFechaCompra fechaCompra;

    public Compra(Long id, Long clienteId, List<Producto> productos, Integer cantidad, BigDecimal precioTotal, Date fechaCompra){
        this.id = new CompraId(clienteId);
        this.clienteId = new CompraClienteId(clienteId);
        this.productos = new CompraProductos(productos);
        this.cantidad = new CompraCantidad(cantidad);
        this.precioTotal = new CompraPrecioTotal(precioTotal);
        this.fechaCompra = new CompraFechaCompra(fechaCompra);
    }

    public Compra requestToCreate(CompraCreateCommand compraCreateCommand){
        this.clienteId = new CompraClienteId(compraCreateCommand.getClienteId());
        this.productos = new CompraProductos(compraCreateCommand.getProductos());
        this.cantidad = new CompraCantidad(compraCreateCommand.getCantidad());
        this.precioTotal = new CompraPrecioTotal(compraCreateCommand.getPrecioTotal());
        this.fechaCompra = new CompraFechaCompra(compraCreateCommand.getFechaCompra());
        return this;
    }

    public Long getId() {
        return id.getId();
    }

    public Long getClienteId() {
        return clienteId.getClienteId();
    }

    public List<Producto> getProductos() {
        return productos.getProductos();
    }

    public Integer getCantidad() {
        return cantidad.getCantidad();
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal.getPrecioTotal();
    }

    public Date getFechaCompra() {
        return fechaCompra.getFechaCompra();
    }
}
