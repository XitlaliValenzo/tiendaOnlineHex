package mx.com.santander.hexagonalmodularmaven.cliente.port.message;

import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;

public interface ClienteKafkaProducerPort {
    void enviarMensajeClienteCreado(Cliente cliente);
}
