package vista;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;

public class ProductoView {
    public int mostrarMenu() {
        String menu = "GESTIoN DE PRODUCTOS\n\n" +
                     "1. Listar productos\n" +
                     "2. Agregar producto\n" +
                     "3. Actualizar producto\n" +
                     "4. Eliminar producto\n" +
                     "5. Buscar por categoria\n" +
                     "6. Buscar por nombre\n" +
                     "7. Actualizar stock\n" +
                     "0. Volver al menu principal\n\n" +
                     "Seleccione una opcion:";
        
        String opcion = JOptionPane.showInputDialog(menu);
        return Integer.parseInt(opcion);
    }
    
    public void mostrarProductos(List<Producto> productos) {
        StringBuilder sb = new StringBuilder();
        sb.append("LISTA DE PRODUCTOS\n\n");
        
        if (productos.isEmpty()) {
            sb.append("No hay productos registrados");
        } else {
            for (Producto p : productos) {
                sb.append(p.toString()).append("\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public Producto mostrarFormularioAgregar() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            String descripcion = JOptionPane.showInputDialog("Descripcion:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio unitario:"));
            String categoria = JOptionPane.showInputDialog("Categoria:");
            
            // Generar ID
            int id = (int) (Math.random() * 1000) + 1;
            
            return new Producto(id, nombre, descripcion, cantidad, precio, categoria);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados");
            return null;
        }
    }
    
    public Producto mostrarFormularioActualizar(Producto producto) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:", producto.getNombre());
            String descripcion = JOptionPane.showInputDialog("Descripcion:", producto.getDescripcion());
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:", producto.getCantidad()));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio unitario:", producto.getPrecio()));
            String categoria = JOptionPane.showInputDialog("Categoria:", producto.getCategoria());
            
            return new Producto(producto.getId(), nombre, descripcion, cantidad, precio, categoria);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados");
            return null;
        }
    }
    
    public int pedirIdProducto() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del producto:");
        return Integer.parseInt(idStr);
    }
    
    public String pedirCategoria() {
        return JOptionPane.showInputDialog("Ingrese la categoria a buscar:");
    }
    
    public String pedirNombre() {
        return JOptionPane.showInputDialog("Ingrese el nombre o parte del nombre a buscar:");
    }
    
    public int pedirCambioStock() {
        String cambioStr = JOptionPane.showInputDialog("Ingrese la cantidad a agregar (positivo) o quitar (negativo):");
        return Integer.parseInt(cambioStr);
    }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}