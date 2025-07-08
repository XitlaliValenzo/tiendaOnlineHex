package mx.com.santander.hexagonalmodularmaven.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteCreateService {

    private final ClienteRepository clienteRepository;

    public Cliente execute(ClienteCreateCommand clienteCreateCommand) {
        Cliente clienteToCreate = new Cliente().requestToCreate(clienteCreateCommand);
        return clienteRepository.create(clienteToCreate);
    }
}
