package mx.com.santander.hexagonalmodularmaven.compra.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.command.CompraCreateCommand;
import mx.com.santander.hexagonalmodularmaven.productosCompra.model.entity.ProductosCompra;

@NoArgsConstructor
@Setter
public class Compra {
    private CompraId id;
    private CompraClienteId clienteId;
    private CompraProductos productos;
    private CompraPrecioTotal precioTotal;
    private CompraFechaCompra fechaCompra;

    public Compra(Long id, Long clienteId, List<ProductosCompra> productos, BigDecimal precioTotal, Date fechaCompra){
        this.id = new CompraId(id);
        this.clienteId = new CompraClienteId(clienteId);
        this.productos = new CompraProductos(productos);
        this.precioTotal = new CompraPrecioTotal(precioTotal);
        this.fechaCompra = new CompraFechaCompra(fechaCompra);
    }

    public Compra requestToCreate(CompraCreateCommand compraCreateCommand){
        this.clienteId = new CompraClienteId(compraCreateCommand.getClienteId());
        List<ProductosCompra> productosList = compraCreateCommand.getProductos().stream()
        .map(p -> {
            ProductosCompra pc = new ProductosCompra().requestToCreate(p);
            pc.setCompra(this); 
            return pc;
        })
        .collect(Collectors.toList());
        this.productos = new CompraProductos(productosList);
        this.fechaCompra = new CompraFechaCompra(new Date());
        return this;
    }

    public Long getId() {
        return id.getId();
    }

    public Long getClienteId() {
        return clienteId.getClienteId();
    }

    public List<ProductosCompra> getProductos() {
        return productos.getProductos();
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal.getPrecioTotal();
    }

    public Date getFechaCompra() {
        return fechaCompra.getFechaCompra();
    }
}
