package mx.com.santander.hexagonalmodularmaven.cliente.service;


import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.exception.ClienteException;
import mx.com.santander.hexagonalmodularmaven.cliente.port.dao.ClienteDao;
import mx.com.santander.hexagonalmodularmaven.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteDeleteService {

    private final ClienteDao clienteDao;
    private final ClienteRepository clienteRepository;

    public void execute(Long id) {
        if(clienteDao.getById(id) == null){
            throw new ClienteException("El id a eliminar"+ id + " no existe");
        } 
        clienteRepository.deleteById(id);
    }

}
