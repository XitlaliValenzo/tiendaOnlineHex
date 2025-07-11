@ExtendWith(MockitoExtension.class)
public class CompraCreateServiceTest {

    @Mock
    private CompraRepository compraRepository;

    @Mock
    private ProductoDao productoDao;

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private CompraCreateService compraCreateService;

    @BeforeEach
    void setUp() {
        compraRepository = mock(CompraRepository.class);
        productoDao = mock(ProductoDao.class);
        productoRepository = mock(ProductoRepository.class);
        compraCreateService = new CompraCreateService(compraRepository, productoDao, productoRepository);
    }

    @Test
    void debeCrearCompraYActualizarStock() {
        CompraCreateCommand command = new CompraCreateCommand();

        Compra compra = new Compra();
        ProductosCompra pc = new ProductosCompra();
        pc.setProductoId(1L);
        pc.setCantidad(2);
        compra.setProductos(Collections.singletonList(pc));

        Producto producto = new Producto(1L, "Laptop", BigDecimal.TEN, 10);

        when(productoDao.getById(1L)).thenReturn(producto);
        when(compraRepository.create(any(Compra.class))).thenReturn(compra);

        Compra result = compraCreateService.execute(command);

        assertNotNull(result);
        verify(productoRepository).update(any(Producto.class));
    }

}
