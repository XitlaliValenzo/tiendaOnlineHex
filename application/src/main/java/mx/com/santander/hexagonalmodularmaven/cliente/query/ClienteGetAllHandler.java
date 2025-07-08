package mx.com.santander.hexagonalmodularmaven.cliente.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.mapper.ClienteDtoMapper;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;

@Component
@RequiredArgsConstructor
public class ClienteGetAllHandler {

    private final ClienteDao clienteDao;
    private final ClienteDtoMapper clienteDtoMapper;

    public List<ClienteDto> execute(){
        return clienteDao.getAll()
        .stream()
        .map(clienteDtoMapper::toDto)
        .collect(Collectors.toList());
    }

}
