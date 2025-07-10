package mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;

@Component
public class ClienteDBMapper {

    public ClienteEntity toDbo(Cliente domain){
        if(domain == null){
            return null;
        }
        return new ClienteEntity(domain.getId(), domain.getNombre(), domain.getApellido(), domain.getEmail(), domain.getTelefono(), domain.getDireccion());
    }

    public ClienteEntity toDboCreate(Cliente domain){
        if(domain == null){
            return null;
        }
        return new ClienteEntity(null, domain.getNombre(), domain.getApellido(), domain.getEmail(), domain.getTelefono(), domain.getDireccion());
    }

    public Cliente toDomain(ClienteEntity entity){
        if(entity == null){
            return null;
        }
        return new Cliente(entity.getId(), entity.getNombre(), entity.getApellido(), entity.getEmail(), entity.getTelefono(), entity.getDireccion());
    }
}
