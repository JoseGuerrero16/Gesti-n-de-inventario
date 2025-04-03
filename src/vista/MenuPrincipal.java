package vista;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    public int mostrarMenu() {
        String menu = "MENU PRINCIPAL\n\n" +
                     "1. Gestion de Productos\n" +
                     "2. Reportes de Inventario\n" +
                     "0. Salir\n\n" +
                     "Seleccione una opcion:";
        
        String opcion = JOptionPane.showInputDialog(menu);
        return Integer.parseInt(opcion);
    }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}