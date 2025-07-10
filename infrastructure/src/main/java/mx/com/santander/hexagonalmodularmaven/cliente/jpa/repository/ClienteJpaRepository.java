package mx.com.santander.hexagonalmodularmaven.cliente.jpa.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteDBMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.jpa.ClienteSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class ClienteJpaRepository implements ClienteRepository{

    private final ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository;
    private final ClienteDBMapper clienteDbMapper;

    @Override
    public Cliente create(Cliente cliente) {
        var clienteToSave = clienteDbMapper.toDboCreate(cliente);
        var clienteSaved = clienteSpringJpaAdapterRepository.save(clienteToSave);
        return clienteDbMapper.toDomain(clienteSaved);
    }

    @Override
    public void deleteById(Long id) {
        clienteSpringJpaAdapterRepository.deleteById(id);
    }

    @Override
    public Cliente update(Cliente cliente) {
        var clienteToUpdate = clienteDbMapper.toDbo(cliente);
        var clienteUpdated = clienteSpringJpaAdapterRepository.save(clienteToUpdate);
        return clienteDbMapper.toDomain(clienteUpdated);
    }

}
