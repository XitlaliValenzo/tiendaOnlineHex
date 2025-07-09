package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoByIdService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoCreateService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoDeleteService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoGetAllService;
import mx.com.santander.hexagonalmodularmaven.producto.service.ProductoUpdateService;

@Configuration
public class ProductoBean {

    @Bean
    public ProductoGetAllService productoGetAllService(ProductoDao productoDao){
        return new ProductoGetAllService(productoDao);
    }

    @Bean 
    public ProductoByIdService productoByIdService(ProductoDao productoDao){
        return new ProductoByIdService(productoDao);
    }

    @Bean
    public ProductoCreateService productoCreateService(ProductoRepository productoRepository){
        return new ProductoCreateService(productoRepository);
    }

    @Bean
    public ProductoUpdateService productoUpdateService(ProductoDao productoDao, ProductoRepository productoRepository){
        return new ProductoUpdateService(productoDao, productoRepository);
    }

    @Bean
    public ProductoDeleteService productoDeleteService(ProductoDao productoDao, ProductoRepository productoRepository){
        return new ProductoDeleteService(productoDao, productoRepository);
    }

}
