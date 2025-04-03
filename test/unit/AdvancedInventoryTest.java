package unit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.*;
import controlador.*;
import vista.*;

public class AdvancedInventoryTest {
    
    private static Database db;
    private ProductoViewMock view;
    private ProductoController controller;
    
    @BeforeClass
    public static void setUpClass() {
        db = new Database();
    }
    
    @Before
    public void setUp() {
        view = new ProductoViewMock();
        controller = new ProductoController(db, view);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddProductWithNullName() {
        view.setNextProduct(new Producto(1, null, "Desc", 10, 5.99, "Electrónica"));
        controller.agregarProducto();
    }
    
    @Test
    public void testExtremeLongInput() {
        String longName = new String(new char[300]).replace('\0', 'a');
        view.setNextProduct(new Producto(1, longName, "Desc", 10, 5.99, "Electrónica"));
        
        try {
            controller.agregarProducto();
            fail("Debería fallar por longitud máxima");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("longitud máxima"));
        }
    }
}