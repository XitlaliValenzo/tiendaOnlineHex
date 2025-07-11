@ExtendWith(MockitoExtension.class)
public class ProductoCreateService {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoCreateService productoCreateService;

    @BeforeEach
    void setUp() {
        productoRepository = mock(ProductoRepository.class);
        productoCreateService = new ProductoCreateService(productoRepository);
    }

    @Test
    void crearProductoTest() {
        Producto producto = new Producto(null, "Mouse", BigDecimal.valueOf(25.0), 100);
        Producto productoGuardado = new Producto(1L, "Mouse", BigDecimal.valueOf(25.0), 100);

        when(productoRepository.save(producto)).thenReturn(productoGuardado);

        Producto result = productoCreateService.execute(producto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Mouse", result.getNombre());
    }

}
