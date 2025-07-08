package mx.com.santander.hexagonalmodularmaven.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.model.exception.ClienteException;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteUpdateService {

    private final ClienteDao clienteDao;
    private final ClienteRepository clienteRepository;

    public Cliente execute(ClienteUpdateCommand clienteUpdateCommand, Long id){
        Cliente currentCliente = clienteDao.getById(id);
        if (currentCliente == null){
            throw new ClienteException("El id a actualizar"+ id + " no existe");
        }
        Cliente clienteToUpdate = new Cliente(currentCliente.getId(), clienteUpdateCommand.getNombre(), clienteUpdateCommand.getApellido(), clienteUpdateCommand.getEmail(), clienteUpdateCommand.getTelefono(), clienteUpdateCommand.getDireccion());
        return clienteRepository.update(clienteToUpdate);
    }

}
