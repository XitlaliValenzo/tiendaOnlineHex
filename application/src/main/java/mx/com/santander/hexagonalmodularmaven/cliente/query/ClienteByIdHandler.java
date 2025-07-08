package mx.com.santander.hexagonalmodularmaven.cliente.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.mapper.ClienteDtoMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;

@Component
@RequiredArgsConstructor
public class ClienteByIdHandler {

    private final ClienteDao clienteDao;
    private final ClienteDtoMapper clienteDtoMapper;

    public ClienteDto execute(Long id){
        return clienteDtoMapper.toDto(clienteDao.getById(id));
    }
}
