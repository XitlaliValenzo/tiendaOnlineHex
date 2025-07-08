package mx.com.santander.hexagonalmodularmaven.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;

@RequiredArgsConstructor
public class ClienteByIdService {

    private final ClienteDao clienteDao;

    public Cliente execute(Long id) {
        return clienteDao.getById(id);
    }

}
