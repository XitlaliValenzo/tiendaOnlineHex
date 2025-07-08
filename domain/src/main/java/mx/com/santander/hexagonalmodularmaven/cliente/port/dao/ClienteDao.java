package mx.com.santander.hexagonalmodularmaven.cliente.port.dao;

import java.util.List;

import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;

public interface ClienteDao {

    List<Cliente> getAll();
    Cliente getById(Long id);
}
