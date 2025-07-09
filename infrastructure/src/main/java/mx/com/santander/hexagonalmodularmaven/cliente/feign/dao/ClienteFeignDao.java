package mx.com.santander.hexagonalmodularmaven.cliente.feign.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteDBMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.feign.ClienteFeignAdapter;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;

@Repository
@RequiredArgsConstructor
public class ClienteFeignDao implements ClienteDao{

    private final ClienteDBMapper clienteDbMapper;
    private final ClienteFeignAdapter clienteFeignAdapter;

	@Override
	public Cliente getById(Long id) {
		final ClienteEntity clienteEntity = clienteFeignAdapter.getCliente(id);
		return clienteDbMapper.toDomain(clienteEntity);
	}

	@Override
	public List<Cliente> getAll() {
		List<ClienteEntity> clientes = clienteFeignAdapter.getClientes();
		return clientes.stream().map(clienteDbMapper::toDomain).collect(Collectors.toList());
	}

}
