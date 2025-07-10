package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.compra.port.repository.CompraRepository;
import mx.com.santander.hexagonalmodularmaven.compra.service.CompraCreateService;

@Configuration
public class CompraBean {
    @Bean
    public CompraCreateService compraCreateService(CompraRepository compraRepository){
        return new CompraCreateService(compraRepository);
    }

}
