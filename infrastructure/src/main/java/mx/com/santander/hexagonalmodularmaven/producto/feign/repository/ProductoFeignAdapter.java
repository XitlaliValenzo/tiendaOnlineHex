package mx.com.santander.hexagonalmodularmaven.producto.feign.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;

@FeignClient(name = "${feign.name}", url = "${feign.base-url}")
public interface ProductoFeignAdapter {

    @RequestMapping(method = RequestMethod.GET, value = "/productos")
    List<ProductoEntity> getProductos();

    @RequestMapping(method = RequestMethod.GET, value = "/productos/{id}", produces = "application/json")
    ProductoEntity getProducto(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/productos")
    ProductoEntity create(ProductoEntity producto);

    @RequestMapping(method = RequestMethod.PUT, value = "/productos/{id}")
    ProductoEntity update(@PathVariable("id") Long id, @RequestBody ProductoEntity producto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/productos/{id}")
    void delete(@PathVariable("id") Long id);
}
