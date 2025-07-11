package mx.com.santander.hexagonalmodularmaven.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.message.ClienteKafkaProducerPort;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteCreateService {

    private final ClienteRepository clienteRepository;
    private final ClienteKafkaProducerPort clienteKafkaProducerPort;

    public Cliente execute(ClienteCreateCommand clienteCreateCommand) {
        Cliente clienteToCreate = new Cliente().requestToCreate(clienteCreateCommand);
        Cliente clienteCreated = clienteRepository.create(clienteToCreate);
        clienteKafkaProducerPort.enviarMensajeClienteCreado(clienteCreated);
        return clienteCreated;
    }
}
