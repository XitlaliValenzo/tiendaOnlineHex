@ExtendWith(MockitoExtension.class)
public class ClienteCreateServiceTest {
    @Mock
    private ClienteRepository clienteRepository;
    
    @Mock
    private ClienteKafkaProducerPort kafkaProducerPort;
    
    @InjectMocks
    private ClienteCreateService clienteCreateService;

    @Test
    void crearClienteTest() {
        Cliente cliente = new Cliente(null, "Juan", "Pérez", "juan.perez@email.com", "5551234567", "Calle Falsa 123");
        Cliente clienteGuardado = new Cliente(1L, "Juan", "Pérez", "juan.perez@email.com", "5551234567", "Calle Falsa 123");

        when(clienteRepository.save(cliente)).thenReturn(clienteGuardado);

        Cliente result = clienteCreateService.execute(cliente);

        assertEquals(1L, result.getId());
        verify(kafkaProducerPort).enviarMensajeClienteCreado(clienteGuardado);
    }
}
