@ExtendWith(MockitoExtension.class)
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"clientes_creados"})
public class ClienteKafkaConsumerIntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void debeConsumirMensajeYMostrarCorreoBienvenida() throws Exception {
        Map<String, Object> configs = KafkaTestUtils.producerProps("localhost:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configs);
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);

        Cliente cliente = new Cliente(1L, "Juan", "Pérez", "juan.perez@email.com");
        String json = objectMapper.writeValueAsString(cliente);

        kafkaTemplate.send("clientes_creados", json);

        Thread.sleep(2000); 
    }

}
