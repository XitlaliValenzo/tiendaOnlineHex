package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteByIdService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteCreateService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteDeleteService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteGetAllService;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteUpdateService;

@Configuration
public class ClienteBean {

    @Bean
    public ClienteGetAllService clienteGetAllService(ClienteDao clienteDao) {
        return new ClienteGetAllService(clienteDao);
    }

    @Bean
    public ClienteByIdService clienteByIdService(ClienteDao clienteDao) {
        return new ClienteByIdService(clienteDao);
    }

    @Bean
    public ClienteCreateService clienteCreateService(ClienteRepository clienteRepository) {
        return new ClienteCreateService(clienteRepository);
    }

    @Bean
    public ClienteUpdateService clienteUpdateService(ClienteDao clienteDao, ClienteRepository clienteRepository) {
        return new ClienteUpdateService(clienteDao, clienteRepository);
    }

    @Bean
    public ClienteDeleteService clienteDeleteService(ClienteDao clienteDao, ClienteRepository clienteRepository) {
        return new ClienteDeleteService(clienteDao, clienteRepository);
    }

}
