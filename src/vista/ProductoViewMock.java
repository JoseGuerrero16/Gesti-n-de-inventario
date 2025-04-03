package vista;
import modelo.Producto;

public class ProductoViewMock extends ProductoView {
    private Producto nextProduct;
    private int nextId;
    private int nextCambio;
    private String[] nextCredentials;
    
    // Setters para configurar los valores
    public void setNextProduct(Producto p) { this.nextProduct = p; }
    public void setNextId(int id) { this.nextId = id; }
    public void setNextCambio(int cambio) { this.nextCambio = cambio; }
    public void setNextCredentials(String[] creds) { this.nextCredentials = creds; }
    
    @Override
    public Producto mostrarFormularioAgregar() {
        return nextProduct;
    }
    
    @Override
    public int pedirIdProducto() {
        return nextId;
    }
    
    @Override
    public int pedirCambioStock() {
        return nextCambio;
    }
    
    public String[] mostrarLogin() {
        return nextCredentials;
    }
}
