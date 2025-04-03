package vista;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;

public class ReporteView {
    public void mostrarReporte(int totalProductos, double valorTotal, List<Producto> agotados) {
        StringBuilder sb = new StringBuilder();
        sb.append("REPORTE DE INVENTARIO\n\n");
        sb.append("Total de productos: ").append(totalProductos).append("\n");
        sb.append("Valor total del inventario: $").append(String.format("%.2f", valorTotal)).append("\n\n");
        
        sb.append("Productos agotados:\n");
        if (agotados.isEmpty()) {
            sb.append("No hay productos agotados");
        } else {
            for (Producto p : agotados) {
                sb.append(p.getNombre()).append(" (ID: ").append(p.getId()).append(")\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}