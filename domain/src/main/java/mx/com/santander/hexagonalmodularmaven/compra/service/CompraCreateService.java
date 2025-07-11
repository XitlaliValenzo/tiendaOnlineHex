package mx.com.santander.hexagonalmodularmaven.compra.service;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.command.CompraCreateCommand;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.Compra;
import mx.com.santander.hexagonalmodularmaven.compra.model.entity.CompraPrecioTotal;
import mx.com.santander.hexagonalmodularmaven.compra.port.repository.CompraRepository;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.ProductoStock;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;
import mx.com.santander.hexagonalmodularmaven.productosCompra.model.entity.ProductosCompra;

@RequiredArgsConstructor
public class CompraCreateService {

    private final CompraRepository compraRepository;
    private final ProductoDao productoDao;
    private final ProductoRepository productoRepository;

    public Compra execute(CompraCreateCommand compraCreateCommand){
        Compra compraTocreate = new Compra().requestToCreate(compraCreateCommand);
        compraTocreate.setPrecioTotal(new CompraPrecioTotal(calcularPrecioTotal(compraTocreate)));
        return compraRepository.create(compraTocreate);
    }

    public BigDecimal calcularPrecioTotal(Compra compraTocreate){
        BigDecimal precioTotal = BigDecimal.ZERO;
        for (ProductosCompra producto : compraTocreate.getProductos()){
            Producto productoItem = productoDao.getById(producto.getProductoId());
            producto.setProducto(productoItem);
            precioTotal = precioTotal.add(productoItem.getPrecio().multiply(BigDecimal.valueOf(producto.getCantidad())));
            actualizarStock(productoItem, producto);
        }
        return precioTotal;
    }

    public void actualizarStock(Producto productoItem, ProductosCompra productoComprado){
        productoItem.setStock(new ProductoStock(productoItem.getStock() - productoComprado.getCantidad()));
        productoRepository.update(productoItem);
    }

}
