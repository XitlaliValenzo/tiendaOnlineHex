package mx.com.santander.hexagonalmodularmaven.cliente.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.service.ClienteDeleteService;

@Component
@RequiredArgsConstructor
public class ClienteDeleteHandler {

    private final ClienteDeleteService clienteDeleteService;

    public void execute(Long id) {
        clienteDeleteService.execute(id);
    }

}
