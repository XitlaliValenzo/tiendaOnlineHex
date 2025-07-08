package mx.com.santander.hexagonalmodularmaven.cliente.port.repository;

import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;

public interface ClienteRepository {

    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    void deleteById(Long id);
}
