package mx.com.santander.hexagonalmodularmaven.cliente.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.mapper.ClienteDtoMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteCreateService;

@Component
@RequiredArgsConstructor
public class ClienteCreateHandler {

    private final ClienteCreateService clienteCreateService;
    private final ClienteDtoMapper clienteDtoMapper;

    public ClienteDto execute(ClienteCreateCommand clienteCreateCommand){
        return clienteDtoMapper.toDto(clienteCreateService.execute(clienteCreateCommand));
    }
}
