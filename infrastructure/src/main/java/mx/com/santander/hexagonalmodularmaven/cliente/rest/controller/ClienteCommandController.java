package mx.com.santander.hexagonalmodularmaven.cliente.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.command.ClienteCreateHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.command.ClienteDeleteHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.command.ClienteUpdateHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteUpdateCommand;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteCommandController {

    private final ClienteCreateHandler clienteCreateHandler;
    private final ClienteUpdateHandler clienteUpdateHandler;
    private final ClienteDeleteHandler clienteDeleteHandler;

    @PostMapping()
    public ClienteDto create(@RequestBody ClienteCreateCommand clienteCreateCommand) {
        return clienteCreateHandler.execute(clienteCreateCommand);
    }

    @PutMapping("/{id}")
    public ClienteDto update(@PathVariable Long id, @RequestBody ClienteUpdateCommand clienteUpdateCommand) {
        return clienteUpdateHandler.execute(clienteUpdateCommand, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteDeleteHandler.execute(id);
    }
}