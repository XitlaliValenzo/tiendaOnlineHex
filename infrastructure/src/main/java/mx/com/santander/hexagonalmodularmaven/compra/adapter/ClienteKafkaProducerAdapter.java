package mx.com.santander.hexagonalmodularmaven.compra.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;
import mx.com.santander.hexagonalmodularmaven.cliente.port.message.ClienteKafkaProducerPort;

@Component
@RequiredArgsConstructor
public class ClienteKafkaProducerAdapter implements ClienteKafkaProducerPort{

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteKafkaProducerAdapter.class);

    private static final String TOPIC = "clientes_creados";

    @Override
    public void enviarMensajeClienteCreado(Cliente cliente){
        String mensaje;
        try {
            mensaje = objectMapper.writeValueAsString(cliente);
            kafkaTemplate.send(TOPIC, mensaje);
            LOGGER.info("Mensaje enviado: " + mensaje);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }   
    }
}
