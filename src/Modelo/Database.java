package modelo;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Producto> productos;
    private List<Usuario> usuarios;
    
    public Database() {
        productos = new ArrayList<>();
        usuarios = new ArrayList<>();
        
        // Usuario de prueba
        usuarios.add(new Usuario("admin", "admin123"));
        
        // Productos de prueba
        productos.add(new Producto(1, "Laptop", "Laptop i7 16GB RAM", 10, 1200.99, "Electrónica"));
        productos.add(new Producto(2, "Camisa", "Camisa manga larga", 50, 25.50, "Ropa"));
        productos.add(new Producto(3, "Arroz", "Arroz blanco 1kg", 100, 2.99, "Alimentos"));
    }
    
    // Metodos
    public List<Producto> getProductos() { return productos; }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public boolean actualizarProducto(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == producto.getId()) {
                productos.set(i, producto);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarProducto(int id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
    
    // Metodos usuario
    public Usuario buscarUsuario(String username) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    // Metodos reporte
    public int getTotalProductos() {
        return productos.size();
    }
    
    public double getValorTotalInventario() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }
        return total;
    }
    
    public List<Producto> getProductosAgotados() {
        List<Producto> agotados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCantidad() <= 0) {
                agotados.add(p);
            }
        }
        return agotados;
    }
    
    public List<Producto> buscarPorCategoria(String categoria) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(p);
            }
        }
        return resultados;
    }
    
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }
}