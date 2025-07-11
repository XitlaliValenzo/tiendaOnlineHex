package mx.com.santander.hexagonalmodularmaven.compra.adapter.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;

@Component
@RequiredArgsConstructor
public class ClienteKafkaConsumerAdapter {

    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteKafkaConsumerAdapter.class);

    @KafkaListener(topics = "clientes_creados", groupId = "my-consumer-group")
    public void recibirMensajeClienteCreado(String mensaje) {
        Cliente cliente;
        try {
            cliente = objectMapper.readValue(mensaje, Cliente.class);
            LOGGER.info("Mensaje recibido:"+ mensaje);
            System.out.println("------ Correo de bienvenida enviado a: " + cliente.getEmail());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
