package integration;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Database;
import modelo.Producto;
import controlador.AuthController;
import controlador.ProductoController;
import vista.AuthViewMock;
import vista.ProductoViewMock;

public class IntegrationTest {
    
    // Variables compartidas para todas las pruebas
    private Database db;
    private AuthViewMock authView;
    private ProductoViewMock productoView;
    private AuthController authController;
    private ProductoController productoController;
    
    @Before
    public void setUp() {
        // Inicializar la base de datos
        db = new Database();
        
        // Crear mocks para las vistas
        authView = new AuthViewMock();
        productoView = new ProductoViewMock();
        
        // Crear controladores con sus dependencias
        authController = new AuthController(db, authView);
        productoController = new ProductoController(db, productoView);
    }
    
    @Test
    public void testLoginExitoso() {
        // Configurar el mock para login exitoso
        authView.setNextCredentials(new String[]{"admin", "admin123"});
        
        // Ejecutar y verificar
        boolean resultado = authController.autenticar();
        assertTrue("El login debería ser exitoso", resultado);
    }
    
    @Test
    public void testFlujoCompletoProducto() {
        // 1. Configurar login
        authView.setNextCredentials(new String[]{"admin", "admin123"});
        
        // 2. Configurar nuevo producto válido
        productoView.setNextProduct(new Producto(999, "Producto Test", "Descripción", 10, 99.99, "Electrónica"));
        
        // 3. Ejecutar flujo completo
        authController.autenticar();
        productoController.agregarProducto();
        
        // 4. Verificar que el producto existe en la base de datos
        Producto productoInsertado = db.buscarProductoPorId(999);
        assertNotNull("El producto debería existir en la base de datos", productoInsertado);
        assertEquals("El nombre del producto no coincide", "Producto Test", productoInsertado.getNombre());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testProductoInvalido() {
        // Configurar producto con datos inválidos
        productoView.setNextProduct(new Producto(-1, "", null, -10, -5.99, ""));
        
        // Esta llamada debería lanzar IllegalArgumentException
        productoController.agregarProducto();
    }
}