package mx.com.santander.hexagonalmodularmaven.cliente.model.entity;

import lombok.NoArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteUpdateCommand;

@NoArgsConstructor
public class Cliente {

    private ClienteId id;
    private ClienteNombre nombre;
    private ClienteApellido apellido;
    private ClienteEmail email;
    private ClienteTelefono telefono;
    private ClienteDireccion direccion;

    public Cliente(Long id, String nombre, String apellido, String email, String telefono, String direccion) {
        this.id = new ClienteId(id);
        this.nombre = new ClienteNombre(nombre);
        this.apellido = new ClienteApellido(apellido);
        this.email = new ClienteEmail(email);
        this.telefono = new ClienteTelefono(telefono);
        this.direccion = new ClienteDireccion(direccion);
    }

    public Cliente requestToCreate(ClienteCreateCommand clienteCreateCommand) {
        this.nombre = new ClienteNombre(clienteCreateCommand.getNombre());
        this.apellido = new ClienteApellido(clienteCreateCommand.getApellido());
        this.email = new ClienteEmail(clienteCreateCommand.getEmail());
        this.telefono = new ClienteTelefono(clienteCreateCommand.getTelefono());
        this.direccion = new ClienteDireccion(clienteCreateCommand.getDireccion());
        return this;
    }

    public Cliente requestToUpdate(ClienteUpdateCommand clienteUpdateCommand) {
        this.nombre = new ClienteNombre(clienteUpdateCommand.getNombre());
        this.apellido = new ClienteApellido(clienteUpdateCommand.getApellido());
        this.email = new ClienteEmail(clienteUpdateCommand.getEmail());
        this.telefono = new ClienteTelefono(clienteUpdateCommand.getTelefono());
        this.direccion = new ClienteDireccion(clienteUpdateCommand.getDireccion());
        return this;
    }

    public Long getId() {
        return id.getId();
    }

    public String getNombre() {
        return nombre.getNombre();
    }

    public String getApellido() {
        return apellido.getApellido();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getTelefono() {
        return telefono.getTelefono();
    }

    public String getDireccion() {
        return direccion.getDireccion();
    }
}
