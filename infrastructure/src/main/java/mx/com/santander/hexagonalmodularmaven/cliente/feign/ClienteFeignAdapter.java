package mx.com.santander.hexagonalmodularmaven.cliente.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;

@FeignClient(name = "jplaceholder-clientes", url = "https://jsonplaceholder.typicode.com")
public interface ClienteFeignAdapter {

    @RequestMapping(method = RequestMethod.GET, value = "/clientes")
    List<ClienteEntity> getClientes();

    @RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = "application/json")
    ClienteEntity getCliente(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/clientes")
    ClienteEntity create(ClienteEntity cliente);

    @RequestMapping(method = RequestMethod.PUT, value = "/clientes/{id}")
    ClienteEntity update(@PathVariable("id") Long id, @RequestBody ClienteEntity cliente);

    @RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
    void delete(@PathVariable("id") Long id);
}