package mx.com.santander.hexagonalmodularmaven.cliente.jpa.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper.ClienteDBMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.jpa.ClienteSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.model.exception.ClienteException;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;

@Repository
@RequiredArgsConstructor
public class ClienteJpaDao implements ClienteDao{

    private final ClienteDBMapper clienteDbMapper;
    private final ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository;

	@Override
    public Cliente getById(Long id) {

        var optionalCliente = clienteSpringJpaAdapterRepository.findById(id);

        if (optionalCliente.isEmpty()){
            throw new ClienteException(
                    String.format("Producto no encontrado", id));
        }

        return clienteDbMapper.toDomain(optionalCliente.get());
    }

    @Override
    public List<Cliente> getAll() {
        return clienteSpringJpaAdapterRepository.findAll()
                .stream()
                .map(clienteDbMapper::toDomain)
                .collect(Collectors.toList());
    }

}
