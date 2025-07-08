package mx.com.santander.hexagonalmodularmaven.cliente.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;

@RequiredArgsConstructor
public class ClienteGetAllService {

    private final ClienteDao clienteDao;

    public List<Cliente> execute() {
        return clienteDao.getAll();
    }

}
