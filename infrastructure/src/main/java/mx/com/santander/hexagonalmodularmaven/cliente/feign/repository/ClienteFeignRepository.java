package mx.com.santander.hexagonalmodularmaven.cliente.feign.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteDBMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.feign.ClienteFeignAdapter;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class ClienteFeignRepository implements ClienteRepository{

    private final ClienteFeignAdapter clienteFeignAdapter;
	private final ClienteDBMapper clienteDbMapper;
	
	@Override
	public Cliente create(Cliente cliente) {
		var clienteToSave = clienteDbMapper.toDboCreate(cliente);
		var clienteSaved = clienteFeignAdapter.create(clienteToSave);
		return clienteDbMapper.toDomain(clienteSaved);
	}

    @Override
    public Cliente update(Cliente cliente) {
        var clienteToUpdate = clienteDbMapper.toDbo(cliente);
        var clienteUpdated = clienteFeignAdapter.update(cliente.getId(), clienteToUpdate);
        return clienteDbMapper.toDomain(clienteUpdated);
    }

    @Override
    public void deleteById(Long id) {
        clienteFeignAdapter.delete(id);
    }

}
