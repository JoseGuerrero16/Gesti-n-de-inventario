package controlador;

import java.util.List;
import modelo.Database;
import modelo.Producto;
import vista.ProductoView;

public class ProductoController {
    private Database db;
    private ProductoView view;
    
    public ProductoController(Database db, ProductoView view) {
        this.db = db;
        this.view = view;
    }
    
    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            int opcion = view.mostrarMenu();
            
            switch (opcion) {
                case 1: // Lista productos
                    listarProductos();
                    break;
                case 2: // Agregar producto
                    agregarProducto();
                    break;
                case 3: // Actualizar producto
                    actualizarProducto();
                    break;
                case 4: // Eliminar producto
                    eliminarProducto();
                    break;
                case 5: // Buscar por categoria
                    buscarPorCategoria();
                    break;
                case 6: // Buscar por nombre
                    buscarPorNombre();
                    break;
                case 7: // Actualizar stock
                    actualizarStock();
                    break;
                case 0: // Salir
                    salir = true;
                    break;
                default:
                    view.mostrarMensaje("Seleccion Erronea");
            }
        }
    }
    
    public void listarProductos() {
        List<Producto> productos = db.getProductos();
        view.mostrarProductos(productos);
    }
    
    public void agregarProducto() {
        Producto p = view.mostrarFormularioAgregar();
        if (p != null) {
            db.agregarProducto(p);
            view.mostrarMensaje("Producto agregado!");
        }
    }
    
    public void actualizarProducto() {
        int id = view.pedirIdProducto();
        Producto p = db.buscarProductoPorId(id);
        
        if (p != null) {
            Producto datosActualizados = view.mostrarFormularioActualizar(p);
            if (datosActualizados != null) {
                db.actualizarProducto(datosActualizados);
                view.mostrarMensaje("Producto actualizado!");
            }
        } else {
            view.mostrarMensaje("Producto no encontrado");
        }
    }
    
    public void eliminarProducto() {
        int id = view.pedirIdProducto();
        boolean eliminado = db.eliminarProducto(id);
        
        if (eliminado) {
            view.mostrarMensaje("Producto eliminado!");
        } else {
            view.mostrarMensaje("Producto no encontrado");
        }
    }
    
    public void buscarPorCategoria() {
        String categoria = view.pedirCategoria();
        List<Producto> resultados = db.buscarPorCategoria(categoria);
        view.mostrarProductos(resultados);
    }
    
    private void buscarPorNombre() {
        String nombre = view.pedirNombre();
        List<Producto> resultados = db.buscarPorNombre(nombre);
        view.mostrarProductos(resultados);
    }
    
    public void actualizarStock() {
        int id = view.pedirIdProducto();
        Producto p = db.buscarProductoPorId(id);
        
        if (p != null) {
            int cambio = view.pedirCambioStock();
            p.setCantidad(p.getCantidad() + cambio);
            db.actualizarProducto(p);
            view.mostrarMensaje("Nueva cantidad: " + p.getCantidad());
        } else {
            view.mostrarMensaje("Producto");
        }
    }
}