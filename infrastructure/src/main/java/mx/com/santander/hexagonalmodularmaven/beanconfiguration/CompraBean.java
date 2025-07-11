package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.compra.port.repository.CompraRepository;
import mx.com.santander.hexagonalmodularmaven.compra.service.CompraCreateService;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@Configuration
public class CompraBean {
    @Bean
    public CompraCreateService compraCreateService(CompraRepository compraRepository, ProductoDao productoDao, ProductoRepository productoRepository){
        return new CompraCreateService(compraRepository, productoDao, productoRepository);
    }

}
