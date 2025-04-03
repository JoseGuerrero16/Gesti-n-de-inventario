package vista;

import javax.swing.JOptionPane;

public class AuthView {
    public String[] mostrarLogin() {
        String username = JOptionPane.showInputDialog("Nombre de usuario:");
        String password = JOptionPane.showInputDialog("Contraseña:");
        return new String[]{username, password};
    }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}