package mx.com.santander.hexagonalmodularmaven.cliente.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.query.ClienteByIdHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.query.ClienteGetAllHandler;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteQueryController {

    private final ClienteGetAllHandler clienteGetAllHandler;
	private final ClienteByIdHandler clienteByIdHandler;

	@GetMapping
	public List<ClienteDto> getAll() {
		return clienteGetAllHandler.execute();
	}

	@GetMapping("/{id}")
	public ClienteDto getById(@PathVariable("id") long id) {
		return clienteByIdHandler.execute(id);
	}

}